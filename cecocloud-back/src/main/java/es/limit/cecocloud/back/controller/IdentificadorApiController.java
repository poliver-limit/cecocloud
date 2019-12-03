/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.dto.UserSession;

/**
 * Controlador per al servei REST de gestió d'identificadors.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(GenericController.API_PATH + "/identificadors")
public class IdentificadorApiController extends AbstractIdentificableApiController<Identificador, String> {

	@Override
	protected String additionalRsqlFilterFromSession(Object userSession) {
		Long companyiaId = ((UserSession)userSession).getC();
		return "companyia.id==" + companyiaId;
	}

	@Override
	protected void completeDtoWithSession(Identificador dto, Object userSession) {
		Long companyiaId = ((UserSession)userSession).getC();
		dto.setCompanyia(GenericReference.toGenericReference(companyiaId));
	}

}
