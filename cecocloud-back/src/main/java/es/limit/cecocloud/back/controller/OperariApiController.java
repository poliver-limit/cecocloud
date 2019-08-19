/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.logic.api.dto.Operari;
import es.limit.cecocloud.logic.api.service.OperariService;

/**
 * Controlador per al servei REST de gestió d'operaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(value = AbstractApiController.API_PATH + OperariApiController.API_CONTROLLER_PATH)
public class OperariApiController extends AbstractIdentificableApiController<Operari, Long> {

	public static final String API_CONTROLLER_PATH = "/operaris";

	@Autowired
	private OperariService service;

	@Override
	protected OperariService getService() {
		return service;
	}

}
