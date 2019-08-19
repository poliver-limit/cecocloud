/**
 * 
 */
package es.limit.cecocloud.back.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.reflections.Reflections;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.logic.api.dto.util.Identificable;

/**
 * Controlador per al servei REST que retorna la llista amb totes
 * les entitats gestionades per l'API.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(value = AbstractApiController.API_PATH)
public class IndexApiController extends AbstractProfileController {

	@GetMapping(produces = "application/json")
	public ResponseEntity<Resources<?>> findAll(
			HttpServletRequest request) {
		Resources<?> resources = new Resources<Object>(
				Collections.emptySet(),
				getApiControllerLinks());
		return ResponseEntity.ok(resources);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Link[] getApiControllerLinks() {
		List<Link> links = new ArrayList<Link>();
		links.add(linkTo(methodOn(getClass()).findAll(null)).withSelfRel());
		Reflections reflections = new Reflections(getClass().getPackage().getName());
		Set<Class<? extends AbstractIdentificableReadOnlyApiController>> identificableApiControllerClasses = reflections.getSubTypesOf(AbstractIdentificableReadOnlyApiController.class);
		for (Class<? extends AbstractIdentificableReadOnlyApiController> apiControllerClass: identificableApiControllerClasses) {
			if (!apiControllerClass.isInterface() && !Modifier.isAbstract(apiControllerClass.getModifiers())) {
				Class<? extends Identificable<?>> dtoClass = getDtoClassFromApiController(apiControllerClass);
				String resourceName = getResourceNameFromClass(dtoClass);
				links.add(linkTo(methodOn(apiControllerClass).find(null, null, null, null)).withRel(resourceName));
			}
		}
		Set<Class<? extends AbstractIdentificableChildReadOnlyApiController>> identificableChildApiControllerClasses = reflections.getSubTypesOf(AbstractIdentificableChildReadOnlyApiController.class);
		for (Class<? extends AbstractIdentificableChildReadOnlyApiController> apiControllerClass: identificableChildApiControllerClasses) {
			if (!apiControllerClass.isInterface() && !Modifier.isAbstract(apiControllerClass.getModifiers())) {
				Class<? extends Identificable<?>> dtoClass = getDtoClassFromApiController(apiControllerClass);
				String resourceName = getResourceNameFromClass(dtoClass);
				links.add(linkTo(methodOn(apiControllerClass).find(null, null, null, null)).withRel(resourceName));
			}
		}
		return links.toArray(new Link[links.size()]);
	}

}
