/**
 * 
 */
package es.limit.cecocloud.facturacio.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.facturacio.logic.api.dto.Projecte;
import es.limit.cecocloud.facturacio.logic.api.module.FacturacioModule;

/**
 * Controlador per al servei REST de gestió de Projecte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(FacturacioModule.API_PATH + "/projectes")
public class ProjecteApiController extends AbstractIdentificableWithIdentificadorApiController<Projecte> {
	/*
	@Autowired
	 EmpresaService empresaService;
	
	@Override
	protected void completeDtoWithSession(Projecte dto, Object userSession) {
		
		super.completeDtoWithSession(dto, userSession);
		
		Empresa empresa = empresaService.getOne(((UserSession)userSession).getE());
		dto.setIdentificador(GenericReference.toGenericReference(empresa.getCodi()));
		
	}*/

	
}
