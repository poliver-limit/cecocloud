/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import es.limit.base.boot.back.controller.AbstractAuthApiController;
import es.limit.base.boot.back.controller.ApiControllerHelper;

/**
 * Controlador per al servei REST per a gestionar el registre d'usuaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(value = ApiControllerHelper.API_PATH + "/auth")
public class AuthApiController extends AbstractAuthApiController {

	@Override
	protected Object parseSessionObject(JsonNode session) {
		// TODO Auto-generated method stub
		return null;
	}

}
