/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.back.controller.ApiControllerHelper;
import es.limit.cecocloud.logic.api.dto.PerfilRol;

/**
 * Controlador per al servei REST de gestió relacions perfil-rol.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(ApiControllerHelper.API_PATH + "/perfilRol")
public class PerfilRolApiController extends AbstractIdentificableApiController<PerfilRol, String> {

}
