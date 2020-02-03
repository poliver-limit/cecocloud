/**
 * 
 */
package es.limit.cecocloud.fact.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.fact.logic.api.dto.Zona;
import es.limit.cecocloud.fact.logic.api.module.FactModuleConfig;

/**
 * Controlador per al servei REST de gestió de zones.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("factZonaApiController")
@RequestMapping(FactModuleConfig.API_PATH + "/zones")
public class ZonaApiController extends AbstractIdentificableWithIdentificadorApiController<Zona> {

}