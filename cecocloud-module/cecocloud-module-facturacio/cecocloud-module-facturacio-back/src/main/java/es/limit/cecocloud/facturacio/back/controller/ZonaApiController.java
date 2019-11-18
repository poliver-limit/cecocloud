/**
 * 
 */
package es.limit.cecocloud.facturacio.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.back.controller.ApiControllerHelper;
import es.limit.cecocloud.facturacio.logic.api.dto.Zona;
import es.limit.cecocloud.facturacio.logic.api.service.ZonaService;

/**
 * Controlador per al servei REST de gestió relacions perfil-rol.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(ApiControllerHelper.API_PATH + "/zones")
public class ZonaApiController extends AbstractIdentificableApiController<Zona, String> {

	@Autowired
	private ZonaService service;

	@Override
	protected ZonaService getService() {
		return service;
	}

}
