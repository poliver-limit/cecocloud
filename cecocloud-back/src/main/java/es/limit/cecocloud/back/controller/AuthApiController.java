/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.limit.base.boot.back.controller.AbstractAuthApiController;
import es.limit.base.boot.back.controller.ApiControllerHelper;
import es.limit.cecocloud.logic.api.dto.UserSession;

/**
 * Controlador per al servei REST per a gestionar el registre d'usuaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(value = ApiControllerHelper.API_PATH + "/auth")
public class AuthApiController extends AbstractAuthApiController {

	@Autowired
	private ObjectMapper jacksonObjectMapper;

	@Override
	protected Object parseSessionObject(JsonNode session) throws JsonProcessingException {
		return jacksonObjectMapper.convertValue(session, UserSession.class);
	}

}
