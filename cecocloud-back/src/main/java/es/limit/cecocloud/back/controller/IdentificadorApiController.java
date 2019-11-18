/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.back.controller.ApiControllerHelper;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.service.IdentificadorService;

/**
 * Controlador per al servei REST de gestió d'identificadors.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(ApiControllerHelper.API_PATH + "/identificadors")
public class IdentificadorApiController extends AbstractIdentificableApiController<Identificador, String> {

	@Autowired
	private IdentificadorService service;

	@Override
	protected IdentificadorService getService() {
		return service;
	}

	@Override
	protected String additionalRsqlFilterFromSession(Object userSession) {
		Long companyiaId = ((UserSession)userSession).getCompanyia();
		return "companyia.id==" + companyiaId;
	}

	@Override
	protected void completeDtoWithSession(Identificador dto, Object userSession) {
		Long companyiaId = ((UserSession)userSession).getCompanyia();
		dto.setCompanyia(GenericReference.toGenericReference(companyiaId));
	}

}
