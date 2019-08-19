/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.logic.api.dto.Marcatge;
import es.limit.cecocloud.logic.api.service.MarcatgeService;

/**
 * Controlador per al servei REST de gestió de marcatges.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(value = AbstractApiController.API_PATH + MarcatgeApiController.API_CONTROLLER_PATH)
public class MarcatgeApiController extends AbstractIdentificableApiController<Marcatge, Long> {

	public static final String API_CONTROLLER_PATH = "/marcatges";

	@Autowired
	private MarcatgeService service;

	@Override
	protected MarcatgeService getService() {
		return service;
	}

}
