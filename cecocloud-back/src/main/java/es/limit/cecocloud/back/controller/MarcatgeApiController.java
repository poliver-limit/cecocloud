/**
 * 
 */
package es.limit.cecocloud.back.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.logic.api.acl.ExtendedPermission;
import es.limit.cecocloud.logic.api.dto.Marcatge;
import es.limit.cecocloud.logic.api.dto.Rol;
import es.limit.cecocloud.logic.api.dto.util.AuthenticationFacade;
import es.limit.cecocloud.logic.api.service.CompanyiaService;
import es.limit.cecocloud.logic.api.service.EmpresaService;
import es.limit.cecocloud.logic.api.service.MarcatgeService;

/**
 * Controlador per al servei REST de gestió de marcatges.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(value = AbstractIdentificableApiController.API_PATH + MarcatgeApiController.API_CONTROLLER_PATH)
public class MarcatgeApiController extends AbstractIdentificableApiController<Marcatge, Long> {

	public static final String API_CONTROLLER_PATH = "/marcatges";

	@Autowired
	private CompanyiaService companyiaService;
	@Autowired
	private EmpresaService empresaService;
	@Autowired
	private MarcatgeService service;
	@Autowired
	private AuthenticationFacade authenticationFacade;

	@Override
	protected MarcatgeService getService() {
		return service;
	}

	@Override
	protected String buildAdditionalRsqlQuery(HttpServletRequest request) {
		boolean isAdmin = hasAnyAuthority(authenticationFacade.getAuthentication(), Rol.ADMIN);
		boolean isAdminCurrentCompanyia = false;
		if (getUserSession(request).getCompanyia() != null) {
			isAdminCurrentCompanyia = companyiaService.permissionCheck(
					getUserSession(request).getCompanyia(),
					ExtendedPermission.ADMINISTRATION);
		}
		boolean isAdminCurrentEmpresa = false;
		if (getUserSession(request).getCompanyia() != null) {
			/*isAdminCurrentEmpresa = empresaService.permissionCheck(
					getUserSession(request).getEmpresa(),
					ExtendedPermission.ADMINISTRATION);*/
		}
		boolean isMarcatge = hasAnyAuthority(authenticationFacade.getAuthentication(), Rol.MARCA);
		if (!isAdmin && isAdminCurrentCompanyia) {
			return "operari.empresa.companyia.id==" + this.getUserSession(request).getCompanyia();
		} else if (!isAdmin && !isAdminCurrentCompanyia && isAdminCurrentEmpresa) {
			return "operari.empresa.id==" + this.getUserSession(request).getEmpresa();
		} else if (!isAdmin && !isAdminCurrentCompanyia && !isAdminCurrentEmpresa && isMarcatge) {
			return "operari.usuari.codi==" + authenticationFacade.getAuthentication().getName();
		}
		return null;
	}

}
