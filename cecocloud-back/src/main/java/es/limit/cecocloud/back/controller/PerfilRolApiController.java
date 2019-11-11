/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.back.controller.ApiControllerHelper;
import es.limit.cecocloud.logic.api.dto.PerfilRol;
import es.limit.cecocloud.logic.api.service.PerfilRolService;

/**
 * Controlador per al servei REST de gestió de perfil-rols.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(ApiControllerHelper.API_PATH + "/perfilRol")
public class PerfilRolApiController extends AbstractIdentificableApiController<PerfilRol, String> {

	@Autowired
	private PerfilRolService service;

	@Override
	protected PerfilRolService getService() {
		return service;
	}

}
