/**
 * 
 */
package es.limit.cecocloud.rrhh.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
import es.limit.cecocloud.rrhh.logic.api.module.RrhhModuleConfig;

/**
 * Controlador per al servei REST de gestió de la entitat Operari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("rrhhOperariApiController")
@RequestMapping(RrhhModuleConfig.API_PATH + "/operaris")
public class OperariApiController extends AbstractIdentificableAmbIdentificadorApiController<Operari> {

}
