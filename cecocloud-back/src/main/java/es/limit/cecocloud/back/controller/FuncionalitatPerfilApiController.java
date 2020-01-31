/**
 * 
 */
package es.limit.cecocloud.back.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.base.boot.logic.api.dto.BaseBootPermission;
import es.limit.cecocloud.logic.api.dto.FuncionalitatInfo;
import es.limit.cecocloud.logic.api.dto.FuncionalitatPerfil;
import es.limit.cecocloud.logic.api.dto.ModuleFuncionalitatInfo;
import es.limit.cecocloud.logic.api.service.FuncionalitatPerfilService;
import lombok.extern.slf4j.Slf4j;

/**
 * Controlador per al servei REST de gestió de recursos de tipus funcionalitat-perfil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@RestController
@RequestMapping(GenericController.API_PATH + "/funcionalitatPerfils")
public class FuncionalitatPerfilApiController extends AbstractIdentificableApiController<FuncionalitatPerfil, Long> {

	@Autowired
	FuncionalitatPerfilService funcionalitatPerfilService;
	
	@GetMapping(value = "/perfil/{perfilId}",
			produces = "application/json")
	public ResponseEntity<List<ModuleFuncionalitatInfo>> findAllFuncionalitatsByPerfillOrderByModule(
			HttpServletRequest request,
			@PathVariable Long perfilId) {
		
		return ResponseEntity.ok(funcionalitatPerfilService.findAllFuncionalitatsByPerfilOrderByModule(perfilId));
	}
	
	@GetMapping(value = "/perfils/{perfilsId}",
			produces = "application/json")
	public ResponseEntity<List<ModuleFuncionalitatInfo>> findAllFuncionalitatsByPerfillOrderByModule(
			HttpServletRequest request,
			@PathVariable Long[] perfilsId) {
		
		return ResponseEntity.ok(funcionalitatPerfilService.findAllFuncionalitatsByPerfilsOrderByModule(Arrays.asList(perfilsId)));
	}
	
	@PostMapping(
			value = "/perfil/{perfilId}/permissions/save",
			produces = "application/json")
	public ResponseEntity<EntityModel<BaseBootPermission>> permissionSave(
			HttpServletRequest request,
			@RequestBody @Valid final FuncionalitatInfo funcionalitat,
			@PathVariable Long perfilId) throws ClassNotFoundException {
		log.debug("Creant permisos de la funcionalitat (" +
				"Funcionalitat=" + funcionalitat.getDescripcio() + ", " +
				"tipus= " + funcionalitat.getTipus() + ", " +
				"permission=" + funcionalitat.getPermission() + ")");
		
		//BaseBootPermission creat = 
		funcionalitatPerfilService.savePermisos(perfilId, funcionalitat);
		
//		if (creat != null) {
//			return ResponseEntity.ok(
//					new EntityModel<BaseBootPermission>(
//							creat,
//							linkTo(methodOn(ResourceApiController.class).findAllRolModuleResources(null, null)).withSelfRel()));
//		} else {
			return ResponseEntity.ok().build();
//		}
	}
	
}
