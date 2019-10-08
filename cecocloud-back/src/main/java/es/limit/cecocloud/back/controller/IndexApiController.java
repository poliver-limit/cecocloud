/**
 * 
 */
package es.limit.cecocloud.back.controller;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador per al servei REST que retorna la llista amb totes
 * les entitats gestionades per l'API.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(value = AbstractIdentificableApiController.API_PATH)
public class IndexApiController {

	@GetMapping(produces = "application/json")
	public ResponseEntity<Resources<?>> findAll(
			HttpServletRequest request) {
		Link[] apiControllerLinks = ApiControllerHelper.getApiControllerClasses().stream().
				map(apiControllerClass -> ApiControllerHelper.getLinkFromApiControllerClass(apiControllerClass, null)).
				toArray(Link[]::new);
		Resources<?> resources = new Resources<Object>(
				Collections.emptySet(),
				apiControllerLinks);
		return ResponseEntity.ok(resources);
	}

}
