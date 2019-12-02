/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.logic.api.dto.PerfilUsuariEmpresa;

/**
 * Controlador per al servei REST de gestió relacions perfil-rol.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(GenericController.API_PATH + "/perfilUsuariEmpresa")
public class PerfilUsuariEmpresaApiController extends AbstractIdentificableApiController<PerfilUsuariEmpresa, String> {

}
