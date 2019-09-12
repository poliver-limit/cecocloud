/**
 * 
 */
package es.limit.cecocloud.back.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Set;

import org.reflections.Reflections;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import es.limit.cecocloud.logic.api.dto.util.Identificable;

/**
 * Mètodes bàsics per als controladors REST de l'API que retornen
 * informació del profile.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
public abstract class ApiControllerHelper {

	@SuppressWarnings("unchecked")
	public static Class<? extends Identificable<?>> getDtoClassFromApiController(Class<?> apiControllerClass) {
		Type genericSuperClass = apiControllerClass.getGenericSuperclass();
		while (genericSuperClass != null && !(genericSuperClass instanceof ParameterizedType)) {
			genericSuperClass = ((Class<?>)genericSuperClass).getGenericSuperclass();
		}
		ParameterizedType parameterizedType = (ParameterizedType)genericSuperClass;
		return (Class<? extends Identificable<?>>)parameterizedType.getActualTypeArguments()[0];
	}

	public static String[] getApiUrlsFromApiController(Class<?> apiControllerClass) {
		RequestMapping requestMapping = apiControllerClass.getAnnotation(RequestMapping.class);
		return (requestMapping != null) ? requestMapping.value() : null;
	}

	public static String getResourceNameFromClass(Class<?> clazz) {
		String simpleName = clazz.getSimpleName();
		return Character.toLowerCase(simpleName.charAt(0)) + simpleName.substring(1);
	}

	@SuppressWarnings("rawtypes")
	public static Set<Class<? extends AbstractIdentificableReadOnlyApiController>> getApiControllerClasses() {
		Reflections reflections = new Reflections(ApiControllerHelper.class.getPackage().getName());
		Set<Class<? extends AbstractIdentificableReadOnlyApiController>> apiControllerClasses = reflections.getSubTypesOf(AbstractIdentificableReadOnlyApiController.class);
		apiControllerClasses.removeIf(apiControllerClass -> (apiControllerClass.isInterface() || Modifier.isAbstract(apiControllerClass.getModifiers())));
		return apiControllerClasses;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected static Link getResourceLink(
			Class<? extends AbstractIdentificableReadOnlyApiController> apiControllerClass,
			Object id,
			String rel) {
		Link link = linkTo(methodOn(apiControllerClass).getOne(null, null)).withRel(rel);
		if (id != null) {
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(link.getHref());
			link = new Link(uriBuilder.buildAndExpand(id).toString());
		}
		return link;
	}
	@SuppressWarnings("rawtypes")
	public static Link getLinkFromApiControllerClass(
			Class<? extends AbstractIdentificableReadOnlyApiController> apiControllerClass,
			String rel) {
		if (rel == null) {
			Class<? extends Identificable<?>> dtoClass = getDtoClassFromApiController(apiControllerClass);
			rel = getResourceNameFromClass(dtoClass);
		}
		Link link = linkTo(methodOn(apiControllerClass).find(null, null, null, null)).withRel(rel);
		return link;
	}

}