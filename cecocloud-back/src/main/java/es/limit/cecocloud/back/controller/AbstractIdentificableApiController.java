/**
 * 
 */
package es.limit.cecocloud.back.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.json.patch.JsonPatchPatchConverter;
import org.springframework.data.rest.webmvc.json.patch.Patch;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.PagedResources.PageMetadata;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.validation.BindingResult;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.limit.cecocloud.back.controller.ApiControllerHelper.SelfLinkBuilder;
import es.limit.cecocloud.logic.api.dto.Profile;
import es.limit.cecocloud.logic.api.dto.ProfileResourceField;
import es.limit.cecocloud.logic.api.dto.Rol;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.dto.util.Identificable;
import es.limit.cecocloud.logic.api.service.AuthService;
import es.limit.cecocloud.logic.api.service.GenericService;
import es.limit.cecocloud.logic.api.service.ProfileService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Mètodes bàsics per als controladors REST que gestionen entitats
 * que depenen d'un identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@RestController
public abstract class AbstractIdentificableApiController<D extends Identificable<ID>, ID extends Serializable> {

	protected static final String API_PATH = "/api";
	protected static final String AUTH_HEADER_BEARER_PREFIX = "Bearer ";
	// protected static final String PATHVARIABLE_DATEFORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
	// @DateTimeFormat(pattern = PATHVARIABLE_DATEFORMAT_PATTERN)

	@Autowired
	protected ObjectMapper objectMapper;
	@Autowired
	private SmartValidator validator;
	@Autowired
	private AuthService authService;
	@Autowired
	private ProfileService profileService;

	private static Class<?> dtoClass;

	@GetMapping(
			value = "/new",
			produces = "application/json")
	public ResponseEntity<Resource<D>> getNew(
			HttpServletRequest request) throws InstantiationException, IllegalAccessException {
		log.debug("Obtenint nova instància");
		@SuppressWarnings("unchecked")
		D newInstance = ((Class<D>)getDtoClass()).newInstance();
		return ResponseEntity.ok(
				toResource(
						newInstance,
						getProfileLink("profile")));
	}

	@PostMapping(
			produces = "application/json")
	public ResponseEntity<Resource<D>> create(
			HttpServletRequest request,
			@RequestBody @Valid final D dto) {
		log.debug("Creant entitat (" +
				"dto=" + dto + ")");
		D creat = getService().create(dto);
		final URI uri = MvcUriComponentsBuilder.fromController(getClass()).
				path("/{id}").
	            buildAndExpand(creat.getId()).
	            toUri();
		return ResponseEntity.created(uri).body(
				toResource(creat));
	}

	@PutMapping(
			value = "/{resourceId}",
			produces = "application/json")
	public ResponseEntity<Resource<D>> update(
			HttpServletRequest request,
			@PathVariable  final ID resourceId,
			@RequestBody @Valid final D dto,
			@RequestParam(required = false) boolean validate) {
		if (!validate) {
			log.debug("Modificant entitat (" +
					"resourceId=" + resourceId + ", " +
					"dto=" + dto + ")");
			D modificat = getService().update(
					resourceId,
					dto);
			return ResponseEntity.ok(toResource(modificat));
		} else {
			log.debug("Validant entitat per modificació (" +
					"resourceId=" + resourceId + ", " +
					"dto=" + dto + ")");
			return ResponseEntity.ok(null);
		}
	}

	@PatchMapping(
			value = "/{resourceId}",
			produces = "application/json")
	public ResponseEntity<Resource<D>> patch(
			HttpServletRequest request,
			@PathVariable final ID resourceId,
			@RequestBody final JsonNode jsonNode,
			BindingResult bindingResult) throws MethodArgumentNotValidException {
		log.debug("Pedaçant entitat (" +
				"resourceId=" + resourceId + ", " +
				"jsonNode=" + jsonNode + ")");
		Patch patch = new JsonPatchPatchConverter(objectMapper).convert(jsonNode);
		@SuppressWarnings("unchecked")
		D patchedDto = patch.apply(
				getService().getOne(resourceId),
				(Class<D>)getDtoClass());
		validator.validate(
				patchedDto,
				bindingResult,
				Default.class);
	    if (bindingResult.hasErrors()) {
	    	throw new MethodArgumentNotValidException(
	    			new MethodParameter(
	    					new Object() {}.getClass().getEnclosingMethod(),
	    					2),
	    			bindingResult);
	    } else {
			D modificat = getService().update(
					resourceId,
					patchedDto);
			Resource<D> resource = toResource(modificat);
			return ResponseEntity.ok(resource);
	    }
	}

	@DeleteMapping(value = "/{resourceId}")
	public ResponseEntity<?> delete(
			HttpServletRequest request,
			@PathVariable final ID resourceId) {
		log.debug("Esborrant entitat (" +
				"resourceId=" + resourceId + ")");
		getService().delete(resourceId);
		return ResponseEntity.ok().build();
	}

	@PostMapping(
			value = "/bulk/delete",
			produces = "application/json")
	public ResponseEntity<BulkOperationResponse<ID>> bulkDelete(
			HttpServletRequest request,
			@RequestBody final BulkDeleteOperation<ID> bulkOperation) {
		log.debug("Esborrant entitat (" +
				"resourceIds=" + bulkOperation.getIds() + ")");
		int successCount = 0;
		int errorCount = 0;
		List<ID> errorIds = new ArrayList<ID>();
		for (ID id: bulkOperation.getIds()) {
			try {
				getService().delete(id);
				successCount++;
			} catch (Exception ex) {
				errorCount++;
				errorIds.add(id);
			}
		}
		return ResponseEntity.ok(
				new BulkOperationResponse<ID>(
						bulkOperation.getIds().length,
						successCount,
						errorCount,
						!errorIds.isEmpty() ? errorIds : null));
	}

	@GetMapping(
			value = "/{resourceId}",
			produces = "application/json")
	public ResponseEntity<Resource<D>> getOne(
			HttpServletRequest request,
			@PathVariable final ID resourceId) {
		log.debug("Obtenint entitat (" +
				"resourceId=" + resourceId + ")");
		try {
			D dto = getService().getOne(resourceId);
			return ResponseEntity.ok(
					toResource(
							dto,
							getSelfLink(dto.getId()),
							getProfileLink("profile")));
		} catch (EntityNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping(
			produces = "application/json")
	public ResponseEntity<PagedResources<Resource<D>>> find(
			HttpServletRequest request,
			@RequestParam(value = "quickFilter", required = false) final String quickFilter,
			@RequestParam(value = "query", required = false) final String query,
			final Pageable pageable) {
		String rsqlQuery = buildServiceRsqlQuery(request, query);
		log.debug("Consulta d'entitats amb filtre i paginació (" +
				"quickFilter=" + quickFilter + ", " +
				"rsqlQuery=" + rsqlQuery + ", " +
				"pageable=" + pageable + ")");
		Page<D> pagina = getService().findPageByQuickFilterAndRsqlQuery(
				quickFilter,
				rsqlQuery,
				pageable);
		return ResponseEntity.ok(
				toPagedResources(
						pagina,
						getClass(),
						new SelfLinkBuilder() {
							@Override
							public Link build(Class<?> apiControllerClass, Object... params) {
								return getSelfLink(params);
							}
						},
						getApiLink(Link.REL_SELF),
						getProfileLink("profile")));
	}

	protected <DD extends Identificable<?>> Resource<DD> toResource(
			DD dto,
			Link... links) {
		return new Resource<DD>(
				dto,
				links);
	}
	protected <DD extends Identificable<?>> Resources<Resource<DD>> toResources(
			List<DD> dtos,
			@SuppressWarnings("rawtypes") Class<? extends AbstractIdentificableApiController> apiControllerClass,
			SelfLinkBuilder selfLinkBuilder,
			Link... links) {
		return new Resources<Resource<DD>>(
				dtos.stream().map(dto -> toResource(dto, selfLinkBuilder.build(apiControllerClass, dto.getId()))).collect(Collectors.toList()),
				links);
	}
	protected <DD extends Identificable<?>> PagedResources<Resource<DD>> toPagedResources(
			Page<DD> page,
			@SuppressWarnings("rawtypes") Class<? extends AbstractIdentificableApiController> apiControllerClass,
			SelfLinkBuilder selfLinkBuilder,
			Link... links) {
		PageMetadata pageMetadata = new PageMetadata(
				page.getNumberOfElements(),
				page.getNumber(),
				page.getTotalElements(),
				page.getTotalPages());
		return new PagedResources<Resource<DD>>(
				page.getContent().stream().map(dto -> toResource(dto, selfLinkBuilder.build(apiControllerClass, dto.getId()), getApiLink("base"))).collect(Collectors.toList()),
				pageMetadata,
				links);
	}
	
	@SuppressWarnings("unchecked" )
	protected Class<?> getDtoClass() {
		if (dtoClass == null) {
			Type genericSuperClass = getClass().getGenericSuperclass();
			while (genericSuperClass != null && !(genericSuperClass instanceof ParameterizedType)) {
				genericSuperClass = ((Class<?>)genericSuperClass).getGenericSuperclass();
			}
			ParameterizedType parameterizedType = (ParameterizedType)genericSuperClass;
			dtoClass = (Class<? extends Identificable<?>>)parameterizedType.getActualTypeArguments()[0];
		}
		return dtoClass;
	}

	@SuppressWarnings("unchecked")
	protected Class<? extends Identificable<?>> getDtoClassFromApiController(Class<?> apiControllerClass) {
		Type genericSuperClass = apiControllerClass.getGenericSuperclass();
		while (genericSuperClass != null && !(genericSuperClass instanceof ParameterizedType)) {
			genericSuperClass = ((Class<?>)genericSuperClass).getGenericSuperclass();
		}
		ParameterizedType parameterizedType = (ParameterizedType)genericSuperClass;
		return (Class<? extends Identificable<?>>)parameterizedType.getActualTypeArguments()[0];
	}

	protected String getResourceNameFromClass(Class<?> clazz) {
		String simpleName = clazz.getSimpleName();
		return Character.toLowerCase(simpleName.charAt(0)) + simpleName.substring(1);
	}

	protected UserSession getUserSession(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		if (authHeader != null && authHeader.startsWith(AUTH_HEADER_BEARER_PREFIX)) {
			String token = authHeader.substring(AUTH_HEADER_BEARER_PREFIX.length()).trim();
			return authService.getUserSession(token);
		}
		return null;
	}

	protected boolean hasAnyAuthority(
			Authentication authentication,
			Rol... roles) {
		if (roles == null || roles.length == 0) {
			return false;
		} else {
			for (GrantedAuthority authority: authentication.getAuthorities()) {
				for (Rol role: roles) {
					if (role.name().equals(authority.getAuthority())) {
						return true;
					}
				}
			}
			return false;
		}
	}

	protected String buildServiceRsqlQuery(
			HttpServletRequest request,
			String rsqlQuery) {
		StringBuilder finalRsqlQuery = new StringBuilder();
		appendRsqlQuery(finalRsqlQuery, rsqlQuery);
		appendRsqlQuery(
				finalRsqlQuery,
				buildRsqlQueryFromRequestParams(request));
		appendRsqlQuery(
				finalRsqlQuery,
				buildAdditionalRsqlQuery(request));
		return (finalRsqlQuery.length() > 0) ? finalRsqlQuery.toString() : null;
	}
	protected String buildAdditionalRsqlQuery(HttpServletRequest request) {
		return null;
	}

	protected Link getApiLink(String rel) {
		return linkTo(methodOn(getClass()).find(null, null, null, null)).withRel(rel);
	}
	protected Link getProfileLink(String rel) {
		return linkTo(methodOn(ProfileApiController.class).getOne(null, getResourceNameFromDtoClass())).withRel(rel);
	}
	@SuppressWarnings("unchecked")
	protected Link getSelfLink(Object... params) {
		return linkTo(methodOn(getClass(), params).getOne(null, null)).withSelfRel();
	}

	protected abstract GenericService<D, ID> getService();

	private String buildRsqlQueryFromRequestParams(HttpServletRequest request) {
		try {
			Profile profile = profileService.getProfile(getDtoClass(), null, null);
			Enumeration<String> paramNames = request.getParameterNames();
			StringBuilder rsqlQuery = new StringBuilder();
			while (paramNames.hasMoreElements()) {
				String paramName = paramNames.nextElement();
				for (ProfileResourceField field: profile.getResource().getFields()) {
					if (paramName.startsWith(field.getName())) {
						if (rsqlQuery.length() == 0) {
							rsqlQuery.append("(");
						} else {
							rsqlQuery.append(";");
						}
						rsqlQuery.append(paramName);
						rsqlQuery.append("==");
						rsqlQuery.append(request.getParameter(paramName));
					}
				}
			}
			return (rsqlQuery.length() > 0) ? rsqlQuery.toString() : null;
		} catch (ClassNotFoundException ex) {
			log.error("No s'ha pogut obtenir el filtre addicional per a la classe " + getDtoClass(), ex);
			return null;
		}
	}

	private void appendRsqlQuery(StringBuilder sb, String rsqlQuery) {
		if (rsqlQuery != null && !rsqlQuery.isEmpty()) {
			if (sb.length() > 0) {
				sb.append(";");
			}
			sb.append("(");
			sb.append(rsqlQuery);
			sb.append(")");
		}
	}

	private String getResourceNameFromDtoClass() {
		String simpleName = getDtoClass().getSimpleName();
		return Character.toLowerCase(simpleName.charAt(0)) + simpleName.substring(1);
	}

	@Getter
	@AllArgsConstructor
	@NoArgsConstructor
	private static class BulkDeleteOperation<ID extends Serializable> {
		@NotEmpty
		private ID[] ids;
	}

	@Getter
	@AllArgsConstructor
	private static class BulkOperationResponse<ID extends Serializable> {
		private int totalCount;
		private int successCount;
		private int errorCount;
		private List<ID> errorIds;
	}

}
