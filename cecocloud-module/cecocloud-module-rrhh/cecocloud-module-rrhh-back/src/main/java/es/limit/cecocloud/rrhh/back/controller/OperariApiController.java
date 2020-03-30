/**
 * 
 */
package es.limit.cecocloud.rrhh.back.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
import es.limit.cecocloud.rrhh.logic.api.module.RrhhModuleConfig;

/**
 * Controlador per al servei REST de gestió de la entitat Operari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("rrhhOperariApiController")
@RequestMapping(RrhhModuleConfig.API_PATH + "/operaris")
public class OperariApiController extends AbstractIdentificableAmbIdentificadorApiController<Operari> {
	
	@Override
	protected String namedRsqlFilter(HttpServletRequest request, Object userSession, String filterName) {
		switch(filterName) {
		case Operari.FILTER_ACTIU:
			return "actiu==true";			
		case Operari.FILTER_ACTIU_ADO:
			return "ado==true;actiu==true";			
		default:
			return null;			
		}		
	}

}
