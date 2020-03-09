/**
 * 
 */
package es.limit.cecocloud.fact.back.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.fact.logic.api.dto.Producte;
import es.limit.cecocloud.fact.logic.api.module.FactModuleConfig;

/**
 * Controlador per al servei REST de gestió de aplicadors.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(FactModuleConfig.API_PATH + "/productes")
public class ProducteApiController extends AbstractIdentificableWithIdentificadorApiController<Producte> {
	
	@Override
	protected String namedRsqlFilter(HttpServletRequest request, Object userSession, String filterName) {
		return "tipus=='APLICACIO'; actiu==true";
	}
	
}


