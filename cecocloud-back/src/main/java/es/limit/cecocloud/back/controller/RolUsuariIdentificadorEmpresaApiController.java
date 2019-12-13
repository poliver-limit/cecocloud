/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.logic.api.dto.RolUsuariIdentificadorEmpresa;
import es.limit.cecocloud.logic.api.dto.UserSession;

/**
 * Controlador per al servei REST de gestió relacions rol-usuariIdentificadorEmpresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(GenericController.API_PATH + "/perfilUsuariEmpresa")
public class RolUsuariIdentificadorEmpresaApiController extends AbstractIdentificableApiController<RolUsuariIdentificadorEmpresa, String> {

	@Override
	protected String additionalRsqlFilterFromSession(Object userSession) {
		Long identificadorId = ((UserSession)userSession).getI();
		return "rol.identificador.id==" + identificadorId;
	}
	
}
