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
import es.limit.cecocloud.facturacio.logic.api.dto.ArticleFamilia;
import es.limit.cecocloud.facturacio.logic.api.service.ArticleFamiliaService;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.service.EmpresaService;

/**
 * Controlador per al servei REST de gestió de articlesFamiliaEmpresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(ApiControllerHelper.API_PATH + "/articlesFamiliaEmpresa")
public class ArticleFamiliaEmpresaApiController extends AbstractIdentificableApiController<ArticleFamilia, String> {

	@Autowired
	private ArticleFamiliaService service;
	@Autowired
	private EmpresaService empresaService;
	
	@Override
	protected ArticleFamiliaService getService() {
		return service;
	}

	@Override
	protected void completeDtoWithSession(ArticleFamilia dto, Object userSession) {
		Long empresaId = ((UserSession)userSession).getEmpresa();
		Empresa empresa = empresaService.getOne(empresaId);
		dto.setIdentificador(GenericReference.toGenericReference(empresa.getIdentificador().getId()));
	}
}
