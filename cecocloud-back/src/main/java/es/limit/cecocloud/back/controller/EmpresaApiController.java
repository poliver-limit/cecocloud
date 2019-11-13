/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableWithPermissionsApiController;
import es.limit.base.boot.back.controller.ApiControllerHelper;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.service.EmpresaService;

/**
 * Controlador per al servei REST de gestió d'empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(ApiControllerHelper.API_PATH + "/empreses")
public class EmpresaApiController extends AbstractIdentificableWithPermissionsApiController<Empresa, Long> {

	@Autowired
	private EmpresaService service;

	@Override
	protected EmpresaService getService() {
		return service;
	}

	@Override
	protected String additionalRsqlFilterFromSession(Object userSession) {
		Long companyiaId = ((UserSession)userSession).getCompanyia();
		return "identificador.companyia.id==" + companyiaId;
	}

}
