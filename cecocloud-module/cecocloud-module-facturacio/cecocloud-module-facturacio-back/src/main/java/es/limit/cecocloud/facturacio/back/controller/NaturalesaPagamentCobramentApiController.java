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
import es.limit.cecocloud.facturacio.logic.api.dto.NaturalesaPagamentCobrament;
import es.limit.cecocloud.facturacio.logic.api.service.NaturalesaPagamentCobramentService;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.service.EmpresaService;

/**
 * Controlador per al servei REST de gestió de Naturaleses de Pagament/Cobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(ApiControllerHelper.API_PATH + "/naturalesesPagamentCobrament")
public class NaturalesaPagamentCobramentApiController extends AbstractIdentificableApiController<NaturalesaPagamentCobrament, String> {

	@Autowired
	private NaturalesaPagamentCobramentService service;
	@Autowired
	private EmpresaService empresaService;
	
	@Override
	protected NaturalesaPagamentCobramentService getService() {
		return service;
	}

	@Override
	protected void completeDtoWithSession(NaturalesaPagamentCobrament dto, Object userSession) {
		Long empresaId = ((UserSession)userSession).getEmpresa();
		Empresa empresa = empresaService.getOne(empresaId);
		dto.setIdentificador(GenericReference.toGenericReference(empresa.getIdentificador().getId()));
	}
}
