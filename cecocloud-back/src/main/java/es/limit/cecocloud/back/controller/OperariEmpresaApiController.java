/**
 * 
 */
package es.limit.cecocloud.back.controller;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.base.boot.logic.api.dto.ProfileResourcePermissions;
import es.limit.cecocloud.logic.api.dto.OperariEmpresa;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.service.OperariEmpresaService;
import lombok.extern.slf4j.Slf4j;

/**
 * Controlador per al servei REST de gestió de recursos de tipus operari-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@RestController
@RequestMapping(GenericController.API_PATH + "/operariEmpreses")
public class OperariEmpresaApiController extends AbstractIdentificableApiController<OperariEmpresa, Long> {

	@Autowired
	private OperariEmpresaService operariEmpresaService;

	@Override
	protected String additionalRsqlFilter(HttpServletRequest request, Object userSession) {
		return "operari.identificador.id==" + ((UserSession)userSession).getI() + ";" + "empresa.identificador.id==" + ((UserSession)userSession).getI();
	}

	@Override
	protected String namedRsqlFilter(HttpServletRequest request, Object userSession, String filterName) {
		if (OperariEmpresa.FILTER_MARC_ALLOWED.equals(filterName)) {
			OperariEmpresa operariEmpresa = null;
			ProfileResourcePermissions resourcePermissions = null;
			try {
				resourcePermissions = this.profileService.getPermissions(
						"marcatge",
						"marc");
			} catch (ClassNotFoundException ex) {
				log.error("Error al obtenir els permisos dels marcatges", ex);
			}
			// Si l'usuari no és administrador de la funcionalitat de marcatges sempre retorna
			// l'operari-empresa associat amb l'usuari actual.
			Long operariEmpresaId = null;
			if (resourcePermissions != null && !resourcePermissions.isHasAdminPermission()) {
				try {
					operariEmpresa = operariEmpresaService.findByCurrentUserAndSession();
				} catch (NoSuchElementException ex) {
					// No s'ha trobat cap operari-empresa
				}
				operariEmpresaId = (operariEmpresa != null) ? operariEmpresa.getId() : -1;
			}
			StringBuilder rsqlFilter = new StringBuilder();
			rsqlFilter.append("empresa.id==");
			rsqlFilter.append(((UserSession)userSession).getE());
			if (operariEmpresaId != null) {
				rsqlFilter.append(";id==");
				rsqlFilter.append(operariEmpresa.getId());
			}
			return rsqlFilter.toString();
		}
		return null;
	}

	@GetMapping(
			value = "/current",
			produces = "application/json")
	@PreAuthorize("hasPermission(0, this.getDtoClassName(), 'READ')")
	public ResponseEntity<EntityModel<OperariEmpresa>> getCurrent() {
		try {
			OperariEmpresa current = ((OperariEmpresaService)getService()).findByCurrentUserAndSession();
			return ResponseEntity.ok(
					toResource(
							current,
							getResourceLinks(current.getId())));
		} catch (NoSuchElementException ex) {
			return ResponseEntity.ok().build();
		}
	}

}
