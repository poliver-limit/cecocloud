/**
 * 
 */
package es.limit.cecocloud.fact.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.fact.logic.api.module.FactModuleConfig;
import es.limit.cecocloud.fact.logic.api.dto.MantenimentDeTipus;

/**
 * Controlador per al servei REST de gestió de MantenimentDeTipus.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("factMantenimentDeTipusApicontroller")
@RequestMapping(FactModuleConfig.API_PATH + "/mantenimentsDeTipus")
public class MantenimentDeTipusApiController extends AbstractIdentificableWithIdentificadorApiController<MantenimentDeTipus> {

}
