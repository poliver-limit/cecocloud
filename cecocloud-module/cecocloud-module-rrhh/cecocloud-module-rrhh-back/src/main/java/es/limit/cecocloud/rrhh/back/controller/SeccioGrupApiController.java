/**
 * 
 */
package es.limit.cecocloud.rrhh.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.rrhh.logic.api.dto.SeccioGrup;
import es.limit.cecocloud.rrhh.logic.api.module.RrhhModuleConfig;

/**
 * Controlador per al servei REST de gestió de la entitat SeccioGrup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(RrhhModuleConfig.API_PATH + "/seccionsGrup")
public class SeccioGrupApiController extends AbstractIdentificableAmbIdentificadorApiController<SeccioGrup> {

}
