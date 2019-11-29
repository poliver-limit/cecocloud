/**
 * 
 */
package es.limit.cecocloud.marcatges.back.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.dto.util.AuthenticationFacade;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.marcatges.logic.api.dto.Marcatge;
import es.limit.cecocloud.marcatges.logic.api.module.MarcatgesModule;

/**
 * Controlador per al servei REST de gestió de marcatges.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(MarcatgesModule.API_PATH + "/marcatges")
public class MarcatgeApiController extends AbstractIdentificableApiController<Marcatge, Long> {

	/*@Autowired
	private CompanyiaService companyiaService;
	@Autowired
	private EmpresaService empresaService;*/
	@Autowired
	private AuthenticationFacade authenticationFacade;

	@Override
	protected String additionalRsqlFilterFromSession(Object userSession) {
		String usuariCodi = authenticationFacade.getAuthentication().getName();
		String rsqlUsuari = "operari.usuari.codi==" + usuariCodi + ";";
		UserSession session = (UserSession)userSession;
		if (session != null) {
			if (session.getCompanyia() != null && session.getEmpresa() != null) {
				return rsqlUsuari + "operari.empresa.identificador.companyia.id==" + session.getCompanyia() + ";operari.empresa.id==" + session.getEmpresa();
			} else if (session.getCompanyia() != null) {
				return rsqlUsuari + "operari.empresa.identificador.companyia.id==" + session.getCompanyia();
			} else {
				// Si no hi ha cap companyia seleccionada no retorna resultats
				return "operari.id==0";
			}
		} else {
			// Si no hi ha sessió no retorna resultats
			return "operari.id==0";
		}
	}
	
	@Override
	protected String additionalRsqlFilter(HttpServletRequest request, boolean bypassSessionFilter) {
		return null;
	}

}
