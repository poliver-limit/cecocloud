/**
 * 
 */
package es.limit.cecocloud.rrhh.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.rrhh.logic.api.dto.RegistreDiari;
import es.limit.cecocloud.rrhh.logic.api.module.RrhhModule;

/**
 * Controlador per al servei REST de gestió de la entitat RegistreDiari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(RrhhModule.API_PATH + "/registresDiari")
public class RegistreDiariApiController extends AbstractIdentificableAmbIdentificadorApiController<RegistreDiari> {

}
