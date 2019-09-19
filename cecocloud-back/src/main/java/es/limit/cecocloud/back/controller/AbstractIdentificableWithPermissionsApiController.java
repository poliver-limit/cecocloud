/**
 * 
 */
package es.limit.cecocloud.back.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.logic.api.dto.Permission;
import es.limit.cecocloud.logic.api.dto.util.Identificable;
import es.limit.cecocloud.logic.api.service.GenericServiceWithPermissions;
import lombok.extern.slf4j.Slf4j;

/**
 * Mètodes bàsics per als controladors REST que gestionen entitats
 * que depenen d'un identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@RestController
public abstract class AbstractIdentificableWithPermissionsApiController<D extends Identificable<ID>, ID extends Serializable> extends AbstractIdentificableApiController<D, ID> {

	@PutMapping(
			value = "/{resourceId}/permission",
			produces = "application/json")
	public ResponseEntity<Resource<Permission>> permissionUpdate(
			HttpServletRequest request,
			@PathVariable /*@DateTimeFormat(pattern = PATHVARIABLE_DATEFORMAT_PATTERN)*/ final ID resourceId,
			@RequestBody @Valid final Permission permission) {
		log.debug("Modificant permis de l'entitat (" +
				"resourceId=" + resourceId + ", " +
				"permission=" + permission + ")");
		Permission modificat = getService().permissionUpdate(resourceId, permission);
		return ResponseEntity.ok(toResource(modificat));
	}

	@GetMapping(
			value = "/{resourceId}/permission",
			produces = "application/json")
	public ResponseEntity<Resources<Resource<Permission>>> permissionGet(
			HttpServletRequest request,
			@PathVariable /*@DateTimeFormat(pattern = PATHVARIABLE_DATEFORMAT_PATTERN)*/ final ID resourceId) {
		log.debug("Obtenint els permisos de l'entitat (" +
				"resourceId=" + resourceId + ")");
		List<Permission> permissions = getService().permissionFind(resourceId);
		return ResponseEntity.ok(
				toResources(
						permissions,
						getClass(),
						getPermissionApiLink(resourceId, Link.REL_SELF)));
	}

	@SuppressWarnings("unchecked")
	protected Link getPermissionApiLink(
			ID resourceId,
			String rel) {
		return linkTo(methodOn(getClass(), resourceId).permissionGet(null, null)).withRel(rel);
	}

	protected abstract GenericServiceWithPermissions<D, ID> getService();

}
