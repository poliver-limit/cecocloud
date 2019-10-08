/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.service.EmpresaService;

/**
 * Controlador per al servei REST de gestió d'empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(value = AbstractIdentificableApiController.API_PATH + EmpresaApiController.API_CONTROLLER_PATH)
public class EmpresaApiController extends AbstractIdentificableApiController<Empresa, Long> {

	public static final String API_CONTROLLER_PATH = "/empreses";

	@Autowired
	private EmpresaService service;

	@Override
	protected EmpresaService getService() {
		return service;
	}

}
