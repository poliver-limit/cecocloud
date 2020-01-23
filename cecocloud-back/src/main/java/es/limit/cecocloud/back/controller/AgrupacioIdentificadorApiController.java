/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.logic.api.dto.AgrupacioIdentificador;
import es.limit.cecocloud.logic.api.dto.UserSession;

/**
 * Controlador per al servei REST de gestió de recursos de tipus agrupacio-identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(GenericController.API_PATH + "/caracteristiquesIdentificador")
public class AgrupacioIdentificadorApiController extends AbstractIdentificableApiController<AgrupacioIdentificador, Long> {

	@Override
	protected String additionalRsqlFilterFromSession(Object userSession) {
		Long identificadorId = ((UserSession)userSession).getI();
		return "identificador.id==" + identificadorId;
	}
}
