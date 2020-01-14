/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableWithCompositePkApiController;
import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.logic.api.dto.PerfilUsuariIdentificadorEmpresa;
import es.limit.cecocloud.logic.api.dto.UserSession;

/**
 * Controlador per al servei REST de gestió relacions perfil-usuariIdentificadorEmpresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(GenericController.API_PATH + "/perfilUsuariIdentificadorEmpreses")
public class PerfilUsuariIdentificadorEmpresaApiController extends AbstractIdentificableWithCompositePkApiController<PerfilUsuariIdentificadorEmpresa> {

	@Override
	protected String additionalRsqlFilterFromSession(Object userSession) {
		Long identificadorId = ((UserSession)userSession).getI();
		return "perfil.identificador.id==" + identificadorId;
	}
	
}
