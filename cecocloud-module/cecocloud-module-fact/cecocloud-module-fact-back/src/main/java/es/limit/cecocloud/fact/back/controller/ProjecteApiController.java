/**
 * 
 */
package es.limit.cecocloud.fact.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.fact.logic.api.dto.Projecte;
import es.limit.cecocloud.fact.logic.api.module.FactModuleConfig;

/**
 * Controlador per al servei REST de gestió de Projecte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(FactModuleConfig.API_PATH + "/projectes")
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
