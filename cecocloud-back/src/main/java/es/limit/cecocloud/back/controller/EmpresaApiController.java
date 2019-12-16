/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.back.generic.controller.AbstractIdentificableAmbIdentificadorWithPermissionsApiController;
import es.limit.cecocloud.logic.api.dto.Empresa;

/**
 * Controlador per al servei REST de gestió d'empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(GenericController.API_PATH + "/empreses")
public class EmpresaApiController extends AbstractIdentificableAmbIdentificadorWithPermissionsApiController<Empresa, Long> {

}
