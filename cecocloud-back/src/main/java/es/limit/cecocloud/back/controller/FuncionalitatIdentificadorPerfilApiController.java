/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.logic.api.dto.FuncionalitatIdentificadorPerfil;

/**
 * Controlador per al servei REST de gestió de recursos de tipus funcionalitat-identificador-perfil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(GenericController.API_PATH + "/funcionalitatIdentificadorPerfils")
public class FuncionalitatIdentificadorPerfilApiController extends AbstractIdentificableApiController<FuncionalitatIdentificadorPerfil, Long> {

}
