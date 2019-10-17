/**
 * 
 */
package es.limit.cecocloud.back.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.logic.api.dto.Operari;
import es.limit.cecocloud.logic.api.dto.Rol;
import es.limit.cecocloud.logic.api.dto.util.AuthenticationFacade;
import es.limit.cecocloud.logic.api.service.OperariService;

/**
 * Controlador per al servei REST de gestió d'operaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(value = AbstractIdentificableApiController.API_PATH + OperariApiController.API_CONTROLLER_PATH)
public class OperariApiController extends AbstractIdentificableApiController<Operari, Long> {

	public static final String API_CONTROLLER_PATH = "/operaris";

	@Autowired
	private OperariService service;
	@Autowired
	private AuthenticationFacade authenticationFacade;

	@Override
	protected OperariService getService() {
		return service;
	}

	@Override
	protected String buildAdditionalRsqlQuery(HttpServletRequest request, boolean admin) {
		boolean isAdmin = hasAnyAuthority(authenticationFacade.getAuthentication(), Rol.ADMIN);
		boolean isMarcatge = hasAnyAuthority(authenticationFacade.getAuthentication(), Rol.MARCA);
		if (!isAdmin && isMarcatge) {
			return "usuari.codi==" + authenticationFacade.getAuthentication().getName();
		}
		return null;
	}

}
