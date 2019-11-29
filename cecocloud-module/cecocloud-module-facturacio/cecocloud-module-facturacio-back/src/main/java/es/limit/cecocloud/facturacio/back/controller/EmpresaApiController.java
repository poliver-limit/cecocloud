/**
 * 
 */
package es.limit.cecocloud.facturacio.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.back.controller.ApiControllerHelper;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.facturacio.logic.api.dto.Empresa;
import es.limit.cecocloud.facturacio.logic.api.service.EmpresaService;

/**
 * Controlador per al servei REST de gestió de empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(ApiControllerHelper.API_PATH + "/empreses")
public class EmpresaApiController extends AbstractIdentificableApiController<Empresa, String> {

	@Autowired
	private EmpresaService service;	
	
	@Override
	protected EmpresaService getService() {
		return service;
	}

	@Override
	protected void completeDtoWithSession(Empresa dto, Object userSession) {		
		dto.setIdentificador(GenericReference.toGenericReference(dto.getIdentificador().getId()));
	}
}
