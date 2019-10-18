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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.back.controller.ApiControllerHelper.SelfLinkBuilder;
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
			@PathVariable final ID resourceId,
			@RequestBody @Valid final Permission permission) {
		log.debug("Creant permis de l'entitat (" +
				"resourceId=" + resourceId + ", " +
				"permission=" + permission + ")");
		Permission creat = getService().permissionCreate(resourceId, permission);
		if (creat != null) {
			return ResponseEntity.ok(
					toResource(
							creat,
							getPermissionSelfLink(resourceId, creat.getId())));
		} else {
			return ResponseEntity.ok().build();
		}
	}

	@PutMapping(
			value = "/{resourceId}/permissions/{permissionId}",
			produces = "application/json")
	public ResponseEntity<Resource<Permission>> permissionUpdate(
			HttpServletRequest request,
			@PathVariable final ID resourceId,
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
		if (modificat != null) {
			return ResponseEntity.ok(
					toResource(
							modificat,
							getPermissionSelfLink(resourceId, modificat.getId())));
		} else {
			return ResponseEntity.ok().build();
		}
	}

	@DeleteMapping(value = "/{resourceId}/permissions/{permissionId}")
	public ResponseEntity<?> permissionDelete(
			HttpServletRequest request,
			@PathVariable final ID resourceId,
			@PathVariable final String permissionId) {
		log.debug("Esborrant entitat (" +
				"resourceId=" + resourceId + ", " +
				"permissionId=" + permissionId + ")");
		getService().permissionDelete(resourceId, permissionId);
		return ResponseEntity.ok().build();
	}

	@GetMapping(
			value = "/{resourceId}/permissions/new",
			produces = "application/json")
	public ResponseEntity<Resource<Permission>> permissionGetNew(
			HttpServletRequest request,
			@PathVariable final ID resourceId) {
		log.debug("Obtenint nova instància del permis de l'entitat (" +
				"resourceId=" + resourceId + ")");
		return ResponseEntity.ok(
				toResource(new Permission()));
	}

	@GetMapping(
			value = "/{resourceId}/permissions/{permissionId}",
			produces = "application/json")
	public ResponseEntity<Resource<Permission>> permissionGetOne(
			HttpServletRequest request,
			@PathVariable final ID resourceId,
			@PathVariable final String permissionId) {
		log.debug("Obtenint un permis de l'entitat (" +
				"resourceId=" + resourceId + ", " +
				"permissionId=" + permissionId + ")");
		Permission permission = getService().permissionGetOne(resourceId, permissionId);
		return ResponseEntity.ok(
				toResource(
						permission,
						getPermissionSelfLink(resourceId, permissionId)));
	}

	@GetMapping(
			value = "/{resourceId}/permissions",
			produces = "application/json")
	public ResponseEntity<Resources<Resource<Permission>>> permissionFind(
			HttpServletRequest request,
			@PathVariable final ID resourceId) {
		log.debug("Obtenint els permisos de l'entitat (" +
				"resourceId=" + resourceId + ")");
		List<Permission> permissions = getService().permissionFind(resourceId);
		return ResponseEntity.ok(
				toResources(
						permissions,
						getClass(),
						new PermissionSelfLinkBuilder<ID>(resourceId),
						getPermissionApiLink(resourceId, Link.REL_SELF)));
	}
	
//	@GetMapping(
//			value = "/alowed",
//			produces = "application/json")
//	public ResponseEntity<PagedResources<Resource<D>>> findAllowed(
//			HttpServletRequest request,
//			@RequestParam(value = "quickFilter", required = false) final String quickFilter,
//			@RequestParam(value = "query", required = false) final String query,
//			final Pageable pageable) {
//		String rsqlQuery = buildServiceRsqlQuery(request, query);
//		log.debug("Consulta d'entitats amb filtre i paginació (" +
//				"quickFilter=" + quickFilter + ", " +
//				"rsqlQuery=" + rsqlQuery + ", " +
//				"pageable=" + pageable + ")");
//		// Obtenim la llista de tots els elements filtrats
//		List<D> llista = getService().findListByQuickFilterAndRsqlQuery(
//				quickFilter,
//				rsqlQuery);
//		// Comprovam si tenim permisos sobre cada un dels elements, 
//		// i en cas afirmatiu guardam el seu identificador
//		List<String> idsAllowed = new ArrayList<String>();
//		for (D dto: llista) {
//			if (getService().permissionCheck(dto.getId(), ExtendedPermission.ADMINISTRATION)) {
//				idsAllowed.add(dto.getId().toString());
//			}
//		}
//		// Afegim els ids permesos al filtre de la consulta
//		String appendRsqlQuery = "id in (" + idsAllowed.stream().collect(Collectors.joining(",")) + ")";
//		String allowedRsqlQuery = appendRsqlQuery(rsqlQuery, appendRsqlQuery);
//		// Realitzam la consulta d'abans filtrant pels ids permesos, i paginant 
//		Page<D> pagina = getService().findPageByQuickFilterAndRsqlQuery(
//				quickFilter,
//				allowedRsqlQuery,
//				pageable);
//		
//		return ResponseEntity.ok(
//				toPagedResources(
//						pagina,
//						getClass(),
//						new SelfLinkBuilder() {
//							@Override
//							public Link build(Class<?> apiControllerClass, Object... params) {
//								return getSelfLink(params);
//							}
//						},
//						getApiLink(Link.REL_SELF),
//						getProfileLink("profile")));
//	}

	private String appendRsqlQuery(String rsqlQuery, String appendRsqlQuery) {
		String finalRsqlQuery = rsqlQuery;
		if (finalRsqlQuery != null && !finalRsqlQuery.isEmpty()) {
			if (finalRsqlQuery.length() > 0) {
				finalRsqlQuery += ";";
			}
			finalRsqlQuery += "(";
			finalRsqlQuery += rsqlQuery;
			finalRsqlQuery += ")";
		}
		return finalRsqlQuery;
	}
	
	@SuppressWarnings("unchecked")
	protected Link getPermissionApiLink(
			ID resourceId,
			String rel) {
		return linkTo(methodOn(getClass(), resourceId).permissionFind(null, null)).withRel(rel);
	}
	@SuppressWarnings("unchecked")
	protected Link getPermissionSelfLink(Object... params) {
		return linkTo(methodOn(getClass(), params).permissionGetOne(null, null, null)).withSelfRel();
	}

	static class PermissionSelfLinkBuilder<ID extends Serializable> extends SelfLinkBuilder {
		ID resourceId;
		PermissionSelfLinkBuilder(ID resourceId) {
			this.resourceId = resourceId;
		}
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public Link build(Class<?> apiControllerClass, Object... params) {
			return linkTo(methodOn(((Class<? extends AbstractIdentificableWithPermissionsApiController>)apiControllerClass), resourceId, params[0]).permissionGetOne(null, null, null)).withSelfRel();
		}
	}

	protected abstract GenericServiceWithPermissions<D, ID> getService();

}
