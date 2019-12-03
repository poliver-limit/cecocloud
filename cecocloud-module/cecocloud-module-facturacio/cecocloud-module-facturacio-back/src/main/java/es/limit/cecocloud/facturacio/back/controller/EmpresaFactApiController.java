/**
 * 
 */
package es.limit.cecocloud.facturacio.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.facturacio.logic.api.dto.EmpresaFact;
import es.limit.cecocloud.facturacio.logic.api.module.FacturacioModule;
import es.limit.cecocloud.facturacio.logic.api.service.EmpresaFactService;

/**
 * Controlador per al servei REST de gestió de empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
//@RestController("factEmpresaApiController")
@RequestMapping(FacturacioModule.API_PATH + "/empreses")
public class EmpresaFactApiController extends AbstractIdentificableApiController<EmpresaFact, String> {

	@Autowired
	private EmpresaFactService service;	
	
	@Override
	protected EmpresaFactService getService() {
		return service;
	}

	@Override
	protected void completeDtoWithSession(EmpresaFact dto, Object userSession) {		
		dto.setIdentificador(GenericReference.toGenericReference(dto.getIdentificador().getId()));
	}
}
