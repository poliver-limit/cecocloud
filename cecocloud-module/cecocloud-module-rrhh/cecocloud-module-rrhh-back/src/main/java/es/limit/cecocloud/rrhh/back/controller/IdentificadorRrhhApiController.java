/**
 * 
 */
package es.limit.cecocloud.rrhh.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.service.EmpresaService;
import es.limit.cecocloud.rrhh.logic.api.dto.IdentificadorRrhh;
import es.limit.cecocloud.rrhh.logic.api.module.RrhhModule;

/**
 * Controlador per al servei REST de gestió de la entitat IdentificadorRrhh.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("IdentificadorRrhhController")
@RequestMapping(RrhhModule.API_PATH + "/identificadorsRrhh")
public class IdentificadorRrhhApiController extends AbstractIdentificableApiController<IdentificadorRrhh, String> {

	@Autowired
	private EmpresaService empresaService;

	@Override
	protected void completeDtoWithSession(IdentificadorRrhh dto, Object userSession) {
		Long empresaId = ((UserSession)userSession).getE();
		if (empresaId != null) {
			Empresa empresa = empresaService.getOne(empresaId);
			dto.setId(empresa.getIdentificador().getId());			
		}
	}

}
