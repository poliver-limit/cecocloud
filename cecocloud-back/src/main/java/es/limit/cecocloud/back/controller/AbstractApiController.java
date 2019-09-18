/**
 * 
 */
package es.limit.cecocloud.back.controller;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.PagedResources.PageMetadata;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.logic.api.dto.Profile;
import es.limit.cecocloud.logic.api.dto.ProfileResourceField;
import es.limit.cecocloud.logic.api.dto.Rol;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.dto.util.Identificable;
import es.limit.cecocloud.logic.api.service.AuthService;
import es.limit.cecocloud.logic.api.service.ProfileService;
import lombok.extern.slf4j.Slf4j;

/**
 * Mètodes bàsics per als controladors REST de l'API.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@Slf4j
public abstract class AbstractApiController {

	protected static final String API_PATH = "/api";
	protected static final String PATHVARIABLE_DATEFORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
	protected static final String AUTH_HEADER_BEARER_PREFIX = "Bearer ";

	private static Class<?> dtoClass;

	@Autowired
	private AuthService authService;
	@Autowired
	private ProfileService profileService;

	protected <D> Resource<D> toResource(
			D dto,
			Link... links) {
		return new Resource<D>(
				dto,
				links);
	}
	@SuppressWarnings("rawtypes")
	protected <D> Resources<Resource<D>> toResources(
			List<D> dtos,
			Class<? extends AbstractIdentificableReadOnlyApiController> apiControllerClass,
			Link... links) {
		return new Resources<Resource<D>>(
				dtos.stream().map(dto -> toResource(dto)).collect(Collectors.toList()),
				links);
	}
	@SuppressWarnings("rawtypes")
	protected <D extends Identificable<?>> PagedResources<Resource<D>> toPagedResources(
			Page<D> page,
			Class<? extends AbstractIdentificableReadOnlyApiController> apiControllerClass,
			Link... links) {
		PageMetadata pageMetadata = new PageMetadata(
				page.getNumberOfElements(),
				page.getNumber(),
				page.getTotalElements(),
				page.getTotalPages());
		return new PagedResources<Resource<D>>(
				page.getContent().stream().map(dto -> toResource(dto, getSelfLink(dto, apiControllerClass))).collect(Collectors.toList()),
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

	@SuppressWarnings("rawtypes")
	private <D extends Identificable<?>> Link getSelfLink(
			D dto,
			Class<? extends AbstractIdentificableReadOnlyApiController> apiControllerClass) {
		return ApiControllerHelper.getResourceLink(apiControllerClass, dto.getId(), Link.REL_SELF);
	}

	private String buildRsqlQueryFromRequestParams(HttpServletRequest request) {
		try {
			Profile profile = profileService.getProfile(getDtoClass(), null);
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

}
