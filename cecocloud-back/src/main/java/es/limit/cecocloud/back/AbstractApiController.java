/**
 * 
 */
package es.limit.cecocloud.back;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.PagedResources.PageMetadata;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.limit.cecocloud.logic.api.dto.util.Identificable;

/**
 * Mètodes bàsics per als controladors REST de l'API.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
public abstract class AbstractApiController<D extends Identificable<?>> {

	protected static final String API_PATH = "/api";
	protected static final String PATHVARIABLE_DATEFORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

	private static Class<?> dtoClass;

	@Autowired
	protected ObjectMapper objectMapper;

	protected Resource<D> toResource(
			D dto,
			Link... links) {
		return new Resource<D>(
				dto,
				links);
	}
	protected Resources<Resource<D>> toResources(
			List<D> dtos,
			Link... links) {
		return new Resources<Resource<D>>(
				dtos.stream().map(dto -> toResource(dto, links)).collect(Collectors.toList()));
	}
	protected PagedResources<Resource<D>> toPagedResources(
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
	protected Class<D> getDtoClass() {
		if (dtoClass == null) {
			Type genericSuperClass = getClass().getGenericSuperclass();
			while (genericSuperClass != null && !(genericSuperClass instanceof ParameterizedType)) {
				genericSuperClass = ((Class<?>)genericSuperClass).getGenericSuperclass();
			}
			ParameterizedType parameterizedType = (ParameterizedType)genericSuperClass;
			dtoClass = (Class<? extends Identificable<?>>)parameterizedType.getActualTypeArguments()[0];
		}
		return (Class<D>)dtoClass;
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

}
