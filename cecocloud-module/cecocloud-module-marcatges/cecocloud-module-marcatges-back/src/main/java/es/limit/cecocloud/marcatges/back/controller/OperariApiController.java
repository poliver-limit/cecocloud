/**
 * 
 */
package es.limit.cecocloud.marcatges.back.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.back.controller.ApiControllerHelper;
import es.limit.base.boot.logic.api.dto.Authority;
import es.limit.base.boot.logic.api.dto.util.AuthenticationFacade;
import es.limit.cecocloud.marcatges.logic.api.dto.Operari;
import es.limit.cecocloud.marcatges.logic.api.service.OperariService;

/**
 * Controlador per al servei REST de gestió d'operaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(ApiControllerHelper.API_PATH + "/operaris")
public class OperariApiController extends AbstractIdentificableApiController<Operari, Long> {

	@Autowired
	private OperariService service;
	@Autowired
	private AuthenticationFacade authenticationFacade;

	@Override
	protected OperariService getService() {
		return service;
	}

	@Override
	protected String additionalRsqlFilter(HttpServletRequest request, boolean admin) {
		/*boolean isAdmin = hasAnyAuthority(authenticationFacade.getAuthentication(), Authority.ADMIN);
		boolean isMarcatge = hasAnyAuthority(authenticationFacade.getAuthentication(), Authority.MARCA);
		if (!isAdmin && isMarcatge) {
			return "usuari.codi==" + authenticationFacade.getAuthentication().getName();
		}*/
		return null;
	}

}
