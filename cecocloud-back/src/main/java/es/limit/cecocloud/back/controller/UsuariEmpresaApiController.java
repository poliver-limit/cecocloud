/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.back.controller.ApiControllerHelper;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.dto.UsuariEmpresa;
import es.limit.cecocloud.logic.api.service.UsuariEmpresaService;

/**
 * Controlador per al servei REST de gestió de relacions usuari-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(ApiControllerHelper.API_PATH + "/usuariEmpresa")
public class UsuariEmpresaApiController extends AbstractIdentificableApiController<UsuariEmpresa, String> {

	@Autowired
	private UsuariEmpresaService service;

	@Override
	protected UsuariEmpresaService getService() {
		return service;
	}

	@Override
	protected String additionalRsqlFilterFromSession(Object userSession) {
		Long companyiaId = ((UserSession)userSession).getCompanyia();
		return "empresa.companyia.id==" + companyiaId;
	}

}
