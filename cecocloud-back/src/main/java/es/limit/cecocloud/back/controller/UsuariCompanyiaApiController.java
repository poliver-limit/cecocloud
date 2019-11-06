/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.back.controller.ApiControllerHelper;
import es.limit.cecocloud.logic.api.dto.UsuariCompanyia;
import es.limit.cecocloud.logic.api.service.UsuariCompanyiaService;

/**
 * Controlador per al servei REST de gestió de companyies.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(ApiControllerHelper.API_PATH + "/usuariCompanyia")
public class UsuariCompanyiaApiController extends AbstractIdentificableApiController<UsuariCompanyia, String> {

	@Autowired
	private UsuariCompanyiaService service;

	@Override
	protected UsuariCompanyiaService getService() {
		return service;
	}

}
