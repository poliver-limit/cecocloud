/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.logic.api.dto.PerfilUsuariIdentificadorEmpresa;
import es.limit.cecocloud.logic.api.dto.UserSession;

/**
 * Controlador per al servei REST de gestió relacions perfil-rol.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(GenericController.API_PATH + "/perfilUsuariEmpresa")
public class PerfilUsuariEmpresaApiController extends AbstractIdentificableApiController<PerfilUsuariIdentificadorEmpresa, String> {

//	@Override
//	protected String additionalRsqlFilterFromSession(Object userSession) {
//		String usuariCodi = SecurityContextHolder.getContext().getAuthentication().getName(); 
//		Long companyiaId = (userSession != null) ? ((UserSession)userSession).getC() : null;
//		if (companyiaId != null) {
//			return "usuariEmpresa.empresa.identificador.companyia.id==" + companyiaId + ";"
//					+ "usuariEmpresa.usuari.codi==" + usuariCodi;
//		} else {
//			return null; // "identificador.companyia.id==0";
//		}
//	}
}
