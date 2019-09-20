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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping(
			value = "/{resourceId}/permissions",
			produces = "application/json")
	public ResponseEntity<Resource<Permission>> permissionCreate(
			HttpServletRequest request,
			@PathVariable @DateTimeFormat(pattern = PATHVARIABLE_DATEFORMAT_PATTERN) final ID resourceId,
			@RequestBody @Valid final Permission permission) {
		log.debug("Creant permis de l'entitat (" +
				"resourceId=" + resourceId + ", " +
				"permission=" + permission + ")");
		Permission creat = getService().permissionCreate(resourceId, permission);
		return ResponseEntity.ok(toResource(creat));
	}

	@PutMapping(
			value = "/{resourceId}/permissions/{permissionId}",
			produces = "application/json")
	public ResponseEntity<Resource<Permission>> permissionUpdate(
			HttpServletRequest request,
			@PathVariable @DateTimeFormat(pattern = PATHVARIABLE_DATEFORMAT_PATTERN) final ID resourceId,
			@PathVariable final String permissionId,
			@RequestBody @Valid final Permission permission) {
		log.debug("Modificant permis de l'entitat (" +
				"resourceId=" + resourceId + ", " +
				"permissionId=" + permissionId + ", " +
				"permission=" + permission + ")");
		Permission modificat = getService().permissionUpdate(
				resourceId,
				permissionId,
				permission);
		return ResponseEntity.ok(toResource(modificat));
	}

	@DeleteMapping(value = "/{resourceId}/permissions/{permissionId}")
	public ResponseEntity<?> permissionDelete(
			HttpServletRequest request,
			@PathVariable @DateTimeFormat(pattern = PATHVARIABLE_DATEFORMAT_PATTERN) final ID resourceId,
			@PathVariable final String permissionId) {
		log.debug("Esborrant entitat (" +
				"resourceId=" + resourceId + ", " +
				"permissionId=" + permissionId + ")");
		getService().permissionDelete(resourceId, permissionId);
		return ResponseEntity.ok().build();
	}

	@GetMapping(
			value = "/{resourceId}/permissions/{permissionId}",
			produces = "application/json")
	public ResponseEntity<Resource<Permission>> permissionGetOne(
			HttpServletRequest request,
			@PathVariable @DateTimeFormat(pattern = PATHVARIABLE_DATEFORMAT_PATTERN) final ID resourceId,
			@PathVariable final String permissionId) {
		log.debug("Obtenint un permis de l'entitat (" +
				"resourceId=" + resourceId + ", " +
				"permissionId=" + permissionId + ")");
		Permission permission = getService().permissionGetOne(resourceId, permissionId);
		return ResponseEntity.ok(toResource(permission));
	}

	@GetMapping(
			value = "/{resourceId}/permissions",
			produces = "application/json")
	public ResponseEntity<Resources<Resource<Permission>>> permissionFind(
			HttpServletRequest request,
			@PathVariable @DateTimeFormat(pattern = PATHVARIABLE_DATEFORMAT_PATTERN) final ID resourceId) {
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
		return linkTo(methodOn(getClass(), resourceId).permissionFind(null, null)).withRel(rel);
	}

	protected abstract GenericServiceWithPermissions<D, ID> getService();

}
