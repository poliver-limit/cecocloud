/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificador;
import lombok.extern.slf4j.Slf4j;

/**
 * Controlador per al servei REST de gestió de relacions usuari-identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@RestController
@RequestMapping(GenericController.API_PATH + "/usuariEmpresa")
public class UsuariIdentificadorApiController extends AbstractIdentificableApiController<UsuariIdentificador, String> {

	@Override
	protected String additionalRsqlFilterFromSession(Object userSession) {
		Long identificadorId = ((UserSession)userSession).getI();
		return "identificador.id==" + identificadorId;
	}

}
