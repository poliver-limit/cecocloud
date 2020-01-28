/**
 * 
 */
package es.limit.cecocloud.back.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.logic.api.dto.FuncionalitatPerfil;
import es.limit.cecocloud.logic.api.dto.ModuleFuncionalitatInfo;
import es.limit.cecocloud.logic.api.service.FuncionalitatPerfilService;

/**
 * Controlador per al servei REST de gestió de recursos de tipus funcionalitat-perfil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(GenericController.API_PATH + "/funcionalitatPerfils")
public class FuncionalitatPerfilApiController extends AbstractIdentificableApiController<FuncionalitatPerfil, Long> {

	@Autowired
	FuncionalitatPerfilService funcionalitatPerfilService;
	
	@GetMapping(value = "/perfil/{perfilId}",
			produces = "application/json")
	public ResponseEntity<List<ModuleFuncionalitatInfo>> findAllFuncionalitatsPerfillOrderByModule(
			HttpServletRequest request,
			@PathVariable Long perfilId) {
		
		return ResponseEntity.ok(funcionalitatPerfilService.findAllFuncionalitatsPerfillOrderByModule(perfilId));
	}
}
