/**
 * 
 */
package es.limit.cecocloud.back.controller;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.logic.api.dto.OperariEmpresa;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.service.OperariEmpresaService;

/**
 * Controlador per al servei REST de gestió de recursos de tipus operari-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(GenericController.API_PATH + "/operariEmpreses")
public class OperariEmpresaApiController extends AbstractIdentificableApiController<OperariEmpresa, Long> {

	@Override
	protected String additionalRsqlFilter(HttpServletRequest request, Object userSession) {
		return
				"operari.identificador.id==" + ((UserSession)userSession).getI() + ";" +
				"empresa.identificador.id==" + ((UserSession)userSession).getI();
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
