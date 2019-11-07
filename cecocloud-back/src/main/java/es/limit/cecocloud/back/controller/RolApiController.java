/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.back.controller.ApiControllerHelper;
import es.limit.cecocloud.logic.api.dto.Rol;
import es.limit.cecocloud.logic.api.service.RolService;

/**
 * Controlador per al servei REST de gestió de rols.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(ApiControllerHelper.API_PATH + "/rols")
public class RolApiController extends AbstractIdentificableApiController<Rol, Long> {

	@Autowired
	private RolService service;

	@Override
	protected RolService getService() {
		return service;
	}

}
