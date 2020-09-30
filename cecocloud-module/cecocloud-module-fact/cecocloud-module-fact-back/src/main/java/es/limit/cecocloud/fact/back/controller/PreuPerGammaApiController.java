/**
 * 
 */
package es.limit.cecocloud.fact.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.fact.logic.api.dto.PreuPerGamma;
import es.limit.cecocloud.fact.logic.api.module.FactModuleConfig;

/**
 * Controlador per al servei REST de gestió de preu per gamma.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("factPreuPerGammaController")
@RequestMapping(FactModuleConfig.API_PATH + "/preusPerGamma")
public class PreuPerGammaApiController extends AbstractIdentificableWithIdentificadorApiController<PreuPerGamma> {

}
