/**
 * 
 */
package es.limit.cecocloud.back.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkRelation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.base.boot.logic.api.dto.BaseBootPermission;
import es.limit.cecocloud.logic.api.dto.FuncionalitatPermis;
import es.limit.cecocloud.logic.api.dto.FuncionalitatPermisModule;
import es.limit.cecocloud.logic.api.dto.Perfil;
import es.limit.cecocloud.logic.api.service.PerfilService;
import lombok.extern.slf4j.Slf4j;

/**
 * Controlador per al servei REST de gestió de recursos de tipus perfil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(GenericController.API_PATH + "/perfils")
@Slf4j
public class PerfilApiController extends AbstractIdentificableWithIdentificadorApiController<Perfil, Long> {

	@GetMapping(value = "/{perfilId}/permisosFuncionalitats",
			produces = "application/json")
	public ResponseEntity<List<FuncionalitatPermisModule>> funcionalitatPermisFind(
			@PathVariable Long perfilId,
			@RequestParam(required = false) Long[] perfilsAddicionalsIds) {
		return ResponseEntity.ok(
				((PerfilService)getService()).funcionalitatPermisFindOrderedByModul(
						perfilId,
						perfilsAddicionalsIds));
	}

	@PostMapping(
			value = "/{perfilId}/permisosFuncionalitats/{modul}",
			produces = "application/json")
	public ResponseEntity<EntityModel<BaseBootPermission>> funcionalitatPermisSave(
			@PathVariable Long perfilId,
			@PathVariable String modul,
			@RequestBody @Valid final FuncionalitatPermis funcionalitatPermis) throws ClassNotFoundException {
		log.debug("Guardant permís de la funcionalitat pel perfil(" +
				"perfilId=" + perfilId + ", " +
				"funcionalitatPermis.descripcio=" + funcionalitatPermis.getDescripcio() + ", " +
				"funcionalitatPermis.tipus= " + funcionalitatPermis.getTipus() + ", " +
				"funcionalitatPermis.permission=" + funcionalitatPermis.getPermission() + ")");
		((PerfilService)getService()).funcionalitatPermisSave(perfilId, modul, funcionalitatPermis);
		return ResponseEntity.ok().build();
	}

	@PostMapping(
			value = "/perfil/{perfilId}/permisosFuncionalitats/refresh",
			produces = "application/json")
	public ResponseEntity<EntityModel<BaseBootPermission>> funcionalitatPermisRefresh(
			@PathVariable Long perfilId) throws ClassNotFoundException {
		log.debug("Refrescant permisos del perfil (" + perfilId + ")");
		((PerfilService)getService()).funcionalitatPermisRefresh(perfilId);
		return ResponseEntity.ok().build();
	}

	/*@GetMapping(value = "/usuari/{modul}",
			produces = "application/json")
	public ResponseEntity<List<String>> findAllowedFuncionalitatsByUsuariAndModule(
			HttpServletRequest request,
			@PathVariable Modul modul) {
		
		return ResponseEntity.ok(funcionalitatPerfilService.findAllowedFuncionalitatsByModul(modul));
	}*/

	@Override
	protected Link[] additionalLinks(Long id) {
		Link funcionalitatsPermisosLink = linkTo(methodOn(getClass()).funcionalitatPermisFind(id, null)).withRel(LinkRelation.of("funcionalitatsPermisos"));
		try {
			Link funcionalitatsPermisosSaveLink = linkTo(methodOn(getClass()).funcionalitatPermisSave(id, null, null)).withRel(LinkRelation.of("funcionalitatsPermisosSave"));
			Link funcionalitatsPermisosRefreshLink = linkTo(methodOn(getClass()).funcionalitatPermisRefresh(id)).withRel(LinkRelation.of("funcionalitatsPermisosRefresh"));
			return new Link[] {funcionalitatsPermisosLink, funcionalitatsPermisosSaveLink, funcionalitatsPermisosRefreshLink};
		} catch (ClassNotFoundException ex) {
			return new Link[] {funcionalitatsPermisosLink};
		}
	}

}
