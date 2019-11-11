/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.back.controller.ApiControllerHelper;
import es.limit.cecocloud.logic.api.dto.Perfil;
import es.limit.cecocloud.logic.api.service.PerfilService;

/**
 * Controlador per al servei REST de gestió de perfils.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(ApiControllerHelper.API_PATH + "/perfils")
public class PerfilApiController extends AbstractIdentificableApiController<Perfil, Long> {

	@Autowired
	private PerfilService service;

	@Override
	protected PerfilService getService() {
		return service;
	}

}
