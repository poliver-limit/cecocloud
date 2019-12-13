/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableWithPermissionsApiController;
import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.UserSession;

/**
 * Controlador per al servei REST de gestió d'empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(GenericController.API_PATH + "/empreses")
public class EmpresaApiController extends AbstractIdentificableWithPermissionsApiController<Empresa, Long> {

	@Override
	protected String additionalRsqlFilterFromSession(Object userSession) {
		Long identificadorId = (userSession != null) ? ((UserSession)userSession).getI() : null;
		if (identificadorId != null) {
			return "identificador.id==" + identificadorId;
		} else {
			return null;
		}
	}

}
