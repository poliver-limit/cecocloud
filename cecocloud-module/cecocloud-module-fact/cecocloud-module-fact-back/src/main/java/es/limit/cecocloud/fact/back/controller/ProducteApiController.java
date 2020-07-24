/**
 * 
 */
package es.limit.cecocloud.fact.back.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.fact.logic.api.dto.Producte;
import es.limit.cecocloud.fact.logic.api.module.FactModuleConfig;
import es.limit.cecocloud.logic.api.service.EmpresaService;

/**
 * Controlador per al servei REST de gestió de aplicadors.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(FactModuleConfig.API_PATH + "/productes")
public class ProducteApiController extends AbstractIdentificableWithIdentificadorApiController<Producte> {

	@Autowired
	protected EmpresaService empresaService;

	@Override
	protected String additionalRsqlFilter(HttpServletRequest request, Object userSession) {
		return AbstractIdentificableWithIdentificadorAndEmpresaApiController.staticAdditionalRsqlFilter(
				identificadorService,
				empresaService,
				userSession);
	}

	@Override
	@SuppressWarnings("unchecked")
	protected void processDto(HttpServletRequest request, Producte dto, Object userSession, boolean isNew) {
		super.processDto(request, dto, userSession, isNew);
		dto.setEmpresa(
				AbstractIdentificableWithIdentificadorAndEmpresaApiController.getEmpresaGenericReferenceFromSession(
						empresaService,
						dto,
						userSession));
	}

	@Override
	protected String namedRsqlFilter(HttpServletRequest request, Object userSession, String filterName) {
		return "tipus=='PRODUCTE';actiu==true";
	}

}


