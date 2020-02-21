/**
 * 
 */
package es.limit.cecocloud.back.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.logic.api.dto.PerfilUsuariIdentificadorEmpresa;
import es.limit.cecocloud.logic.api.dto.UserSession;

/**
 * Controlador per al servei REST de gestió de recursos de tipus perfil-(usuari-identificador-empresa).
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(GenericController.API_PATH + "/perfilUsuariIdentificadorEmpreses")
public class PerfilUsuariIdentificadorEmpresaApiController extends AbstractIdentificableApiController<PerfilUsuariIdentificadorEmpresa, Long> {

	@Override
	protected String additionalRsqlFilter(HttpServletRequest request, Object userSession) {
		Long identificadorId = ((UserSession)userSession).getI();
		return "perfil.identificador.id==" + identificadorId;
	}

}
