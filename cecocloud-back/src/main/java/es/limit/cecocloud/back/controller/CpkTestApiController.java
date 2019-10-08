/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.logic.api.dto.CompositePkTest;
import es.limit.cecocloud.logic.api.service.CompositePkTestService;

/**
 * Controlador per al servei REST de gestió d'cpktests.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(value = AbstractIdentificableApiController.API_PATH + CpkTestApiController.API_CONTROLLER_PATH)
public class CpkTestApiController extends AbstractIdentificableApiController<CompositePkTest, String> {

	public static final String API_CONTROLLER_PATH = "/cpktest";

	@Autowired
	private CompositePkTestService service;

	@Override
	protected CompositePkTestService getService() {
		return service;
	}

}
