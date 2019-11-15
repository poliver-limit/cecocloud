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
import es.limit.base.boot.logic.api.dto.Authorities;
import es.limit.base.boot.logic.api.dto.util.AuthenticationFacade;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.marcatges.logic.api.dto.Marcatge;
import es.limit.cecocloud.marcatges.logic.api.service.MarcatgeService;

/**
 * Controlador per al servei REST de gestió de marcatges.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(ApiControllerHelper.API_PATH + "/marcatges")
public class MarcatgeApiController extends AbstractIdentificableApiController<Marcatge, Long> {

	/*@Autowired
	private CompanyiaService companyiaService;
	@Autowired
	private EmpresaService empresaService;*/
	@Autowired
	private MarcatgeService service;
	@Autowired
	private AuthenticationFacade authenticationFacade;

	@Override
	protected MarcatgeService getService() {
		return service;
	}

	@Override
	protected String additionalRsqlFilter(HttpServletRequest request, boolean admin) {
		boolean isAdmin = hasAnyAuthority(authenticationFacade.getAuthentication(), Authorities.ADMIN);
		boolean isAdminCurrentCompanyia = false;
//		if (getUserSession(request).getCompanyia() != null) {
//			isAdminCurrentCompanyia = companyiaService.permissionCheck(
//					getUserSession(request).getCompanyia(),
//					ExtendedPermission.ADMINISTRATION);
//		}
		boolean isAdminCurrentEmpresa = false;
//		if (getUserSession(request).getCompanyia() != null) {
//			/*isAdminCurrentEmpresa = empresaService.permissionCheck(
//					getUserSession(request).getEmpresa(),
//					ExtendedPermission.ADMINISTRATION);*/
//		}
		UserSession userSession = (UserSession)getUserSession(request);
		boolean isMarcatge = hasAnyAuthority(authenticationFacade.getAuthentication(), Authorities.MARCA);
		if (!isAdmin && isAdminCurrentCompanyia) {
			return "operari.empresa.companyia.id==" + userSession.getCompanyia();
		} else if (!isAdmin && !isAdminCurrentCompanyia && isAdminCurrentEmpresa) {
			return "operari.empresa.id==" + userSession.getEmpresa();
		} else if (!isAdmin && !isAdminCurrentCompanyia && !isAdminCurrentEmpresa && isMarcatge) {
			return "operari.usuari.codi==" + authenticationFacade.getAuthentication().getName();
		}
		return null;
	}

}
