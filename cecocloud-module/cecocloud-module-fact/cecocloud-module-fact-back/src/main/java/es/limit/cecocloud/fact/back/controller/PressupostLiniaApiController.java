/**
 * 
 */
package es.limit.cecocloud.fact.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.fact.logic.api.dto.PressupostLinia;
import es.limit.cecocloud.fact.logic.api.module.FactModuleConfig;

/**
 * Controlador per al servei REST de gestió de PressupostLinia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("factPressupostLiniaController")
@RequestMapping(FactModuleConfig.API_PATH + "/pressupostosLinia")
public class PressupostLiniaApiController extends AbstractIdentificableWithIdentificadorApiController<PressupostLinia> {

}
