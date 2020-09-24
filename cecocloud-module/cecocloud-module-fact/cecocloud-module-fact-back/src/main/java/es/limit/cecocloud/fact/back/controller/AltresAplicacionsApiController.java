/**
 * 
 */
package es.limit.cecocloud.fact.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.fact.logic.api.dto.AltresAplicacions;
import es.limit.cecocloud.fact.logic.api.module.FactModuleConfig;

/**
 * Controlador per al servei REST de gestió de altres aplicacions.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("factAltresAplicacionsController")
@RequestMapping(FactModuleConfig.API_PATH + "/altresAplicacions")
public class AltresAplicacionsApiController extends AbstractIdentificableWithIdentificadorApiController<AltresAplicacions> {

}
