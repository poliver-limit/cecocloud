/**
 * 
 */
package es.limit.cecocloud.rrhh.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.service.EmpresaService;
import es.limit.cecocloud.rrhh.logic.api.dto.RecursGrup;
import es.limit.cecocloud.rrhh.logic.api.module.RrhhModule;

/**
 * Controlador per al servei REST de gestió de la entitat RecursGrup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(RrhhModule.API_PATH + "/recursosGrup")
public class RecursGrupApiController extends AbstractIdentificableApiController<RecursGrup, String> {

	@Autowired
	private EmpresaService empresaService;

	@Override
	protected void completeDtoWithSession(RecursGrup dto, Object userSession) {
		Long empresaId = ((UserSession)userSession).getE();
		if (empresaId != null) {
			Empresa empresa = empresaService.getOne(empresaId);
			dto.setIdentificador(GenericReference.toGenericReference(empresa.getIdentificador().getId()));
		}
	}

}
