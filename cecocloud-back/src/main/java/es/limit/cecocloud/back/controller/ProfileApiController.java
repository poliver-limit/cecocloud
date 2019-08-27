/**
 * 
 */
package es.limit.cecocloud.back.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.lang.reflect.Modifier;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.logic.api.dto.Profile;
import es.limit.cecocloud.logic.api.dto.util.Identificable;
import es.limit.cecocloud.logic.api.service.ProfileService;

/**
 * Controlador per al servei REST que retorna la informació del perfil
 * d'un recurs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(value = AbstractApiController.API_PATH + ProfileApiController.API_CONTROLLER_PATH)
public class ProfileApiController extends AbstractProfileController {

	public static final String API_CONTROLLER_PATH = "/profiles";

	@Autowired
	private ProfileService profileService;

	@GetMapping(value = "/{resourceName}", produces = "application/json")
	public ResponseEntity<Resource<Profile>> getOne(
			HttpServletRequest request,
			@PathVariable final String resourceName) {
		try {
			linkTo(methodOn(getClass()).getOne(null, resourceName)).withRel(resourceName).getHref();
			Profile profile = profileService.getProfile(
					resourceName,
					linkTo(methodOn(getClass()).getOne(null, resourceName)).withRel(resourceName).getHref());
			Link selfLink = linkTo(methodOn(getClass()).getOne(null, resourceName)).withSelfRel();
			Link apiLink = getApiLink(resourceName);
			if (apiLink != null) {
				return ResponseEntity.ok(
						new Resource<Profile>(
								profile,
								selfLink,
								apiLink));
			} else {
				return ResponseEntity.ok(
						new Resource<Profile>(
								profile,
								selfLink));
			}
		} catch (ClassNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@SuppressWarnings("rawtypes")
	private Link getApiLink(String resourceName) {
		Reflections reflections = new Reflections(getClass().getPackage().getName());
		Set<Class<? extends AbstractIdentificableReadOnlyApiController>> apiControllerClasses = reflections.getSubTypesOf(AbstractIdentificableReadOnlyApiController.class);
		for (Class<? extends AbstractIdentificableReadOnlyApiController> apiControllerClass: apiControllerClasses) {
			if (!apiControllerClass.isInterface() && !Modifier.isAbstract(apiControllerClass.getModifiers())) {
				Class<? extends Identificable<?>> dtoClass = getDtoClassFromApiController(apiControllerClass);
				String controllerResourceName = getResourceNameFromClass(dtoClass);
				if (controllerResourceName.equalsIgnoreCase(resourceName)) {
					return linkTo(methodOn(apiControllerClass).find(null, null, null, null)).withRel("api");
				}
			}
		}
		return null;
	}

}
