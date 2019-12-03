/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.logic.api.dto.PerfilRol;
import es.limit.cecocloud.logic.api.dto.UserSession;

/**
 * Controlador per al servei REST de gestió relacions perfil-rol.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(GenericController.API_PATH + "/perfilRol")
public class PerfilRolApiController extends AbstractIdentificableApiController<PerfilRol, String> {

	@Override
	protected String additionalRsqlFilterFromSession(Object userSession) {
		Long companyiaId = ((UserSession)userSession).getC();
		return "perfil.companyia.id==" + companyiaId;
	}
	
}
