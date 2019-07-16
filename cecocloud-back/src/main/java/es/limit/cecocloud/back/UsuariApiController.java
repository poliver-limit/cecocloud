/**
 * 
 */
package es.limit.cecocloud.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.logic.api.dto.Usuari;
import es.limit.cecocloud.logic.api.service.UsuariService;

/**
 * Controlador per al servei REST de gestió d'usuaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(value = AbstractApiController.API_PATH + UsuariApiController.API_CONTROLLER_PATH)
public class UsuariApiController extends AbstractIdentificableApiController<Usuari, Long> {

	public static final String API_CONTROLLER_PATH = "/usuaris";

	@Autowired
	private UsuariService service;

	@Override
	protected UsuariService getService() {
		return service;
	}

}
