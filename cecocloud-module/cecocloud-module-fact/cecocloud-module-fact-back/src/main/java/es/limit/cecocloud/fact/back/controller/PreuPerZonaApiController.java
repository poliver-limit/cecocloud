/**
 * 
 */
package es.limit.cecocloud.fact.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.fact.logic.api.dto.PreuPerZona;
import es.limit.cecocloud.fact.logic.api.module.FactModuleConfig;

/**
 * Controlador per al servei REST de gestió de preu per zona.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("factPreuPerZonaController")
@RequestMapping(FactModuleConfig.API_PATH + "/preusPerZona")
public class PreuPerZonaApiController extends AbstractIdentificableWithIdentificadorApiController<PreuPerZona> {

}
