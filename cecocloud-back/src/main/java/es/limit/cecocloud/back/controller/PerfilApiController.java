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
import es.limit.cecocloud.logic.api.dto.Perfil;
import es.limit.cecocloud.logic.api.dto.UserSession;
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

	@Override
	protected String additionalRsqlFilterFromSession(Object userSession) {
		Long companyiaId = ((UserSession)userSession).getCompanyia();
		return "companyia.id==" + companyiaId;
	}

	@Override
	protected void completeDtoWithSession(Perfil dto, Object userSession) {
		Long companyiaId = ((UserSession)userSession).getCompanyia();
		dto.setCompanyia(GenericReference.toGenericReference(companyiaId));
	}

}
