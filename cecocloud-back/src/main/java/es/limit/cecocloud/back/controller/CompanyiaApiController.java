/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.logic.api.dto.Companyia;
import es.limit.cecocloud.logic.api.service.CompanyiaService;

/**
 * Controlador per al servei REST de gestió de companyies.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(value = AbstractApiController.API_PATH + CompanyiaApiController.API_CONTROLLER_PATH)
public class CompanyiaApiController extends AbstractIdentificableWithPermissionsApiController<Companyia, Long> {

	public static final String API_CONTROLLER_PATH = "/companyies";

	@Autowired
	private CompanyiaService service;

	@Override
	protected CompanyiaService getService() {
		return service;
	}

}
