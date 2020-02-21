/**
 * 
 */
package es.limit.cecocloud.marc.back.controller;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.dto.ProfileResourcePermissions;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.dto.OperariEmpresa;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.service.OperariEmpresaService;
import es.limit.cecocloud.marc.logic.api.dto.Marcatge;
import es.limit.cecocloud.marc.logic.api.module.MarcModule;

/**
 * Controlador per al servei REST de gestió de marcatges.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(MarcModule.API_PATH + "/marcatges")
public class MarcatgeApiController extends AbstractIdentificableApiController<Marcatge, Long> {

	@Autowired
	private OperariEmpresaService operariEmpresaService;

	@Override
	protected String additionalRsqlFilter(HttpServletRequest request, Object userSession) {
		ProfileResourcePermissions resourcePermissions = getResourcePermissions();
		String filtreOperari = null;
		if (!resourcePermissions.isHasAdminPermission()) {
			try {
				OperariEmpresa operariEmpresa = operariEmpresaService.findByCurrentUserAndSession();
				filtreOperari = "operariEmpresa.id==" + operariEmpresa.getId();
			} catch (NoSuchElementException ex) {
				// No s'ha trobat cap operari-empresa
			}
		}
		return
				(filtreOperari != null) ? filtreOperari : "" + 
				"operariEmpresa.empresa.id==" + ((UserSession)userSession).getE() + ";" +
				"operariEmpresa.empresa.identificador.id==" + ((UserSession)userSession).getI() + ";" +
				"operariEmpresa.operari.identificador.id==" + ((UserSession)userSession).getI();
	}

	@Override
	protected void completeDtoWithSession(Marcatge dto, Object userSession, boolean isNew) {
		ProfileResourcePermissions resourcePermissions = getResourcePermissions();
		// - Quan cream un nou marcatge sempre es configura l'operari de l'usuari actual.
		// - Quan es guarda/modifica un marcatge només es força l'operari de l'usuari actual
		// si no es tenen permisos d'administració a damunt els marcatges.
		if (isNew || !resourcePermissions.isHasAdminPermission()) {
			try {
				OperariEmpresa operariEmpresa = operariEmpresaService.findByCurrentUserAndSession();
				GenericReference<OperariEmpresa, Long> operariEmpresaRef = GenericReference.toGenericReference(operariEmpresa);
				operariEmpresaRef.setDescription(operariEmpresa.getDescription());
				dto.setOperariEmpresa(operariEmpresaRef);
			} catch (NoSuchElementException ex) {
				// No s'ha trobat cap operari-empresa
				dto.setOperariEmpresa(null);
			}
		}
	}

}
