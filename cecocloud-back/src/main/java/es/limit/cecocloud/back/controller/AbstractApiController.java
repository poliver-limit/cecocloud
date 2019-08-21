/**
 * 
 */
package es.limit.cecocloud.back.controller;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
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
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.dto.util.Identificable;
import es.limit.cecocloud.logic.api.service.AuthService;

/**
 * Mètodes bàsics per als controladors REST de l'API.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
public abstract class AbstractApiController {

	protected static final String API_PATH = "/api";
	protected static final String PATHVARIABLE_DATEFORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
	protected static final String AUTH_HEADER_BEARER_PREFIX = "Bearer ";

	private static Class<?> dtoClass;

	@Autowired
	protected ObjectMapper objectMapper;
	@Autowired
	private AuthService authService;

	protected <D> Resource<D> toResource(
			D dto,
			Link... links) {
		return new Resource<D>(
				dto,
				links);
	}
	protected <D> Resources<Resource<D>> toResources(
			List<D> dtos,
			Link... links) {
		return new Resources<Resource<D>>(
				dtos.stream().map(dto -> toResource(dto, links)).collect(Collectors.toList()));
	}
	protected <D> PagedResources<Resource<D>> toPagedResources(
			Page<D> page,
			Link... links) {
		PageMetadata pageMetadata = new PageMetadata(
				page.getNumberOfElements(),
				page.getNumber(),
				page.getTotalElements(),
				page.getTotalPages());
		return new PagedResources<Resource<D>>(
				page.getContent().stream().map(dto -> toResource(dto)).collect(Collectors.toList()),
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

}
