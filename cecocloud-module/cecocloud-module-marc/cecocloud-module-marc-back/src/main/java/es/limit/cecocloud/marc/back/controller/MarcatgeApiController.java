/**
 * 
 */
package es.limit.cecocloud.marc.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.marc.logic.api.dto.Marcatge;
import es.limit.cecocloud.marc.logic.api.module.MarcModule;

/**
 * Controlador per al servei REST de gestió de marcatges.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(MarcModule.API_PATH + "/marcatges")
public class MarcatgeApiController extends AbstractIdentificableApiController<Marcatge, Long> {

	@Override
	protected String additionalRsqlFilterFromSession(Object userSession) {
		return 
				"operariEmpresa.empresa.id==" + ((UserSession)userSession).getE() + ";" +
				"operariEmpresa.empresa.identificador.id==" + ((UserSession)userSession).getI() + ";" +
				"operariEmpresa.operari.identificador.id==" + ((UserSession)userSession).getI();
		/*String usuariCodi = authenticationFacade.getAuthentication().getName();
		String rsqlUsuari = "operari.usuari.codi==" + usuariCodi + ";";
		UserSession session = (UserSession)userSession;
		if (session != null) {
			if (session.getC() != null && session.getE() != null) {
				return rsqlUsuari + "operari.empresa.identificador.companyia.id==" + session.getC() + ";operari.empresa.id==" + session.getE();
			} else if (session.getC() != null) {
				return rsqlUsuari + "operari.empresa.identificador.companyia.id==" + session.getC();
			} else {
				// Si no hi ha cap companyia seleccionada no retorna resultats
				return "operari.id==0";
			}
		} else {
			// Si no hi ha sessió no retorna resultats
			return "operari.id==0";
		}
		return null;*/
	}

}
