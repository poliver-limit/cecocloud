/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.logic.api.dto.Perfil;

/**
 * Controlador per al servei REST de gestió de perfils.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(GenericController.API_PATH + "/perfils")
public class PerfilApiController extends AbstractIdentificableWithIdentificadorApiController<Perfil, Long> {

}
