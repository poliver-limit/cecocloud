/**
 * 
 */
package es.limit.cecocloud.ecom.back.ecommerce.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.groups.Default;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkRelation;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.PagedModel.PageMetadata;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.ClassUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.limit.base.boot.back.controller.ApiControllerHelper.ResourceLinksBuilder;
import es.limit.base.boot.back.controller.ProfileApiController;
import es.limit.base.boot.logic.api.dto.Authority;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.dto.Identificable.OnUpdate;
import es.limit.base.boot.logic.api.dto.Profile;
import es.limit.base.boot.logic.api.dto.ProfileResourceField;
import es.limit.base.boot.logic.api.dto.ProfileResourcePermissions;
import es.limit.base.boot.logic.api.module.AbstractModules;
import es.limit.base.boot.logic.api.module.ModuleInfo;
import es.limit.base.boot.logic.api.service.AuthService;
import es.limit.base.boot.logic.api.service.GenericService;
import es.limit.base.boot.logic.api.service.ProfileService;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>Classe base pels controladors de l'API REST que conté els mètodes
 * necessaris per a gestionar entitats que consten d'un únic camp a la seva
 * clau primària.</p>
 * <p>A l'hora d'estendre d'aquesta classe per a crear un nou Controller de
 * l'API REST s'ha de tenir en compte el següent:</p>
 * <ul>
 * <li>La classe ha d'incorporar l'anotació @RestController</li>
 * <li>La classe ha d'incorporar l'anotació @RequestMapping i el mapeig ha de
 * tenir com a prefix GenericController.API_PATH</li>
 * </ul>
 * 
 * @param <D>
 *            el tipus del DTO que ha de gestionar aquest Controller. Aquest
 *            tipus ha d'estendre de Identificable&lt;D&gt;.
 * @param <ID>
 *            el tipus de la clau primària de l'entitat que correspon al
 *            DTO. Aquest tipus ha d'implementar Serializable.
 * 
 * @author Limit Tecnologies
 */
@Slf4j
@RestController
public abstract class AbstractIdentificableEcomApiController<D extends Identificable<ID>, ID extends Serializable> {

	protected static final String AUTH_HEADER_BEARER_PREFIX = "Bearer ";

	@Autowired
	private GenericService<D, ID> controllerService;
	@Autowired
	protected ObjectMapper objectMapper;
	@Autowired
	private AuthService authService;
	@Autowired
	protected ProfileService profileService;
	private Class<?> dtoClass;
	
	
	@PostMapping(
			produces = "application/json")
	public ResponseEntity<EntityModel<D>> create(
			HttpServletRequest request,
			@RequestBody @Validated({OnCreate.class, Default.class}) final D dto) {
		log.debug("Creant entitat (" +
				"dto=" + dto + ")");
		completeDtoWithSession(dto, getUserSession(request), false);
		D creat = getService().create(dto);
		final URI uri = MvcUriComponentsBuilder.fromController(getClass()).
				path("/{id}").
				buildAndExpand(creat.getId()).
				toUri();
		return ResponseEntity.created(uri).body(
				toResource(creat, getResourceLinks(creat.getId())));
	}

	@PutMapping(
			value = "/{resourceId}",
			produces = "application/json")
	public ResponseEntity<EntityModel<D>> update(
			HttpServletRequest request,
			@PathVariable final ID resourceId,
			@RequestBody @Validated({OnUpdate.class, Default.class}) final D dto) {
		log.debug("Modificant entitat (" +
				"resourceId=" + resourceId + ", " +
				"dto=" + dto + ")");
		completeDtoWithSession(dto, getUserSession(request), false);
		D modificat = getService().update(
				resourceId,
				dto,
				additionalRsqlFilter(request, getUserSession(request)));
		return ResponseEntity.ok(
				toResource(modificat, getResourceLinks(modificat.getId())));
	}


	@GetMapping(
			value = "/{resourceId}",
			produces = "application/json")
	public ResponseEntity<EntityModel<D>> getOne(
			HttpServletRequest request,
			@PathVariable final ID resourceId) {
		log.debug("Obtenint entitat (" +
				"resourceId=" + resourceId + ")");
		try {
			D dto = getService().getOne(resourceId);
			return ResponseEntity.ok(
					toResource(dto, getResourceLinks(dto.getId())));
		} catch (EntityNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping(
			produces = "application/json")
	public ResponseEntity<PagedModel<EntityModel<D>>> find(
			HttpServletRequest request,
			@RequestParam(value = "namedFilter", required = false) final String[] namedFilters,
			@RequestParam(value = "quickFilter", required = false) final String quickFilter,
			@RequestParam(value = "query", required = false) final String query,
			@RequestParam(value = "lang", required = false) final String idiomaCodi,
			final Pageable pageable,
			final Sort sort) {
		log.debug("Consultant entitats amb filtre i paginació (" +
				"namedFilter=" + namedFilters + "," +
				"quickFilter=" + quickFilter + "," +
				"query=" + query + "," +
				"pageable=" + pageable + "," +
				"sort=" + sort + ")");
		long t0 = System.currentTimeMillis();
		long initialTime = t0;
		String rsqlQuery = buildServiceRsqlQuery(
				request,
				query,
				namedFilters);
		log.debug("\tconsulta RSQL final: " + rsqlQuery);
		long queryBuildTime = System.currentTimeMillis() - t0;
		log.trace("\ttemps de càlcul de la consulta RSQL: " + queryBuildTime + "ms");
		t0 = System.currentTimeMillis();
		Page<D> pagina = getService().findPageByQuickFilterAndRsqlQuery(
				quickFilter,
				rsqlQuery,
				pageable,
				sort);
		long queryTime = System.currentTimeMillis() - t0;
		log.trace("\ttemps de consulta: " + queryTime + "ms");
		t0 = System.currentTimeMillis();
		ResponseEntity<PagedModel<EntityModel<D>>> response = ResponseEntity.ok(
				toPagedResources(
						pagina,
						getClass(),
						getDefaultResourceLinksBuilder()));
		long conversionTime = System.currentTimeMillis() - t0;
		log.trace("\\ttemps de conversió dels resultats: " + conversionTime + "ms");
		long totalTime = System.currentTimeMillis() - initialTime;
		log.trace("\\ttemps total:" + totalTime + "ms");
		return response;
	}



	protected GenericService<D, ID> getService() {
		return controllerService;
	}

	protected <DD extends Identificable<?>> EntityModel<DD> toResource(
			DD dto,
			Link... links) {
		return new EntityModel<DD>(
				dto,
				links);
	}
	protected <DD extends Identificable<?>> CollectionModel<EntityModel<DD>> toResources(
			List<DD> dtos,
			@SuppressWarnings("rawtypes") Class<? extends AbstractIdentificableEcomApiController> apiControllerClass,
			ResourceLinksBuilder resourceLinksBuilder,
			Link... links) {
		return new CollectionModel<EntityModel<DD>>(
				dtos.stream().map(dto -> toResource(dto, resourceLinksBuilder.build(apiControllerClass, dto.getId()))).collect(Collectors.toList()),
				links);
	}
	protected <DD extends Identificable<?>> PagedModel<EntityModel<DD>> toPagedResources(
			Page<DD> page,
			@SuppressWarnings("rawtypes") Class<? extends AbstractIdentificableEcomApiController> apiControllerClass,
			ResourceLinksBuilder resourceLinksBuilder,
			Link... links) {
		PageMetadata pageMetadata = new PageMetadata(
				page.getNumberOfElements(),
				page.getNumber(),
				page.getTotalElements(),
				page.getTotalPages());
		return new PagedModel<EntityModel<DD>>(
				page.getContent().stream().map(dto -> {
					EntityModel<DD> resource = toResource(dto, resourceLinksBuilder.build(apiControllerClass, dto.getId()));
					log.trace("EntityModel:" + resource);
					return resource;
				}).collect(Collectors.toList()),
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
	
	public String getDtoClassName() {
		return ClassUtils.getUserClass(getDtoClass()).getName();
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

	protected Object getUserSession(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		if (authHeader != null && authHeader.startsWith(AUTH_HEADER_BEARER_PREFIX)) {
			String token = authHeader.substring(AUTH_HEADER_BEARER_PREFIX.length()).trim();
			return authService.getUserSession(token);
		}
		return null;
	}

	protected boolean hasAnyAuthority(
			Authentication authentication,
			Authority... roles) {
		if (roles == null || roles.length == 0) {
			return false;
		} else {
			for (GrantedAuthority authority: authentication.getAuthorities()) {
				for (Authority role: roles) {
					if (role.name().equals(authority.getAuthority())) {
						return true;
					}
				}
			}
			return false;
		}
	}

	protected ProfileResourcePermissions getResourcePermissions() {
		return profileService.getPermissions(getDtoClass());
	}

	protected String buildServiceRsqlQuery(
			HttpServletRequest request,
			String rsqlQuery,
			String[] namedFilters) {
		StringBuilder finalRsqlQuery = new StringBuilder();
		appendRsqlQuery(finalRsqlQuery, rsqlQuery);
		appendRsqlQuery(
				finalRsqlQuery,
				buildRsqlQueryFromRequestParams(request));
		appendRsqlQuery(
				finalRsqlQuery,
				additionalRsqlFilter(request, getUserSession(request)));
		if (namedFilters != null) {
			for (String filterName: namedFilters) {
				appendRsqlQuery(
						finalRsqlQuery,
						namedRsqlFilter(request, getUserSession(request), filterName));
			}
		}
		return (finalRsqlQuery.length() > 0) ? finalRsqlQuery.toString() : null;
	}

	protected ResourceLinksBuilder getDefaultResourceLinksBuilder() {
		return new ResourceLinksBuilder() {
			private ID idRef;
			Link[] linksRef;
			private boolean linksGenerats = false;
			@SuppressWarnings("unchecked")
			@Override
			public Link[] build(
					Class<?> apiControllerClass,
					Object... params) {
				ID id = (ID)params[0];
				Link[] links = getCopyOfResourceLinks(id);
				for (int i = 0; i < links.length; i++) {
					links[i] = getLinkWithHrefProcessed(linksRef[i], id);
				}
				return links;
			}
			private Link[] getCopyOfResourceLinks(ID id) {
				idRef = getIdReferencia(id);
				if (!linksGenerats) {
					linksRef = getResourceLinks(idRef);
					linksGenerats = true;
				}
				return linksRef.clone();
			}
			private Link getLinkWithHrefProcessed(
					Link link,
					ID id) {
				try {
					String token = URLEncoder.encode(idRef.toString(), "UTF-8");
					if (link.getHref().contains(token)) {
						return new Link(
								link.getHref().replace(token, id.toString()),
								link.getRel());
					}
				} catch (UnsupportedEncodingException ex) {
					log.error("No s'ha pogut processar l'atribut href del link", ex);
				}
				return link;
			}
		};
	}

	protected Link[] getResourceLinks(ID id) {
		Link[] links = null;
		Long ti = System.currentTimeMillis();
		Link[] baseLinks;
		if (id != null) {
			baseLinks = new Link[] {
					getSelfLink(id),
					getApiLink(),
					getProfileLink()};
		} else {
			baseLinks = new Link[] {
					getApiLink(),
					getProfileLink()};
		}
		Link[] additionalLinks = additionalLinks(id);
		if (additionalLinks != null && additionalLinks.length > 0) {
			links = ArrayUtils.addAll(baseLinks, additionalLinks);
		} else {
			links = baseLinks;
		}
		Long tf = System.currentTimeMillis();
		log.trace("Temps generacio de Resource Links: " + (tf - ti) + "ms");
		return links;
	}
	@SuppressWarnings("unchecked")
	protected Link getSelfLink(Object... params) {
		Long ti = System.currentTimeMillis();
		Link link = linkTo(methodOn(getClass(), params).getOne(null, null)).withSelfRel();
		Long tf = System.currentTimeMillis();
		log.trace("Temps getSelfLink: " + (tf - ti) + "ms");
		log.trace("Link: " + link);
		
		return link;
	}
	protected Link getApiLink() {
		Long ti = System.currentTimeMillis();
		Link link = linkTo(methodOn(getClass()).find(null, null, null, null, null, null, null)).withRel(LinkRelation.of("api"));
		Long tf = System.currentTimeMillis();
		log.trace("Temps getApiLink: " + (tf - ti) + "ms");
		log.trace("Link: " + link);
		return link;
	}
	protected Link getProfileLink() {
		Long ti = System.currentTimeMillis();
		Link link = linkTo(methodOn(ProfileApiController.class).getOne(null, getResourceNameFromDtoClass(), getModuleFromDtoClass())).withRel(LinkRelation.of("profile"));
		Long tf = System.currentTimeMillis();
		log.trace("Temps getProfileLink: " + (tf - ti) + "ms");
		log.trace("Link: " + link);
		return link;
	}

	@SuppressWarnings("unchecked")
	private ID getIdReferencia(ID id) {
		ID idRef = null;
		if (id instanceof String) {
			idRef = (ID) "#IDREF#";
		} else if (id instanceof Long) {
			idRef = (ID)new Long(Long.MIN_VALUE);
		} else if (id instanceof Integer) {
			idRef = (ID)new Integer(Integer.MIN_VALUE);
		}
		return idRef;
	}

	protected String additionalRsqlFilter(HttpServletRequest request, Object userSession) {
		return null;
	}
	protected String namedRsqlFilter(HttpServletRequest request, Object userSession, String filterName) {
		return null;
	}
	protected void completeDtoWithSession(D dto, Object userSession, boolean isNew) {
	}
	protected Link[] additionalLinks(ID id) {
		return null;
	}

	private String buildRsqlQueryFromRequestParams(HttpServletRequest request) {
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
	
	private String getModuleFromDtoClass() {
		String dtoPackageName = getDtoClass().getPackage().getName();
		for (ModuleInfo moduleInfo: AbstractModules.registeredFindAll()) {
			if (dtoPackageName.equals(moduleInfo.getDtoPackage())) {
				return moduleInfo.getCode();
			}
		}
		return null;
	}

}
