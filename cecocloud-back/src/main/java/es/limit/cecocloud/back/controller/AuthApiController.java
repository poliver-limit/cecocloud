/**
 * 
 */
package es.limit.cecocloud.back.controller;

import com.fasterxml.jackson.databind.JsonNode;

import es.limit.base.boot.back.controller.AbstractAuthApiController;

/**
 * Controlador per al servei REST per a gestionar el registre d'usuaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class AuthApiController extends AbstractAuthApiController {

	@Override
	protected Object parseSessionObject(JsonNode session) {
		// TODO Auto-generated method stub
		return null;
	}

}
