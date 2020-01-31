/**
 * 
 */
package es.limit.cecocloud.fact.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.fact.logic.api.dto.TarifaDescompte;
import es.limit.cecocloud.fact.logic.api.module.FactModuleConfig;

/**
 * Controlador per al servei REST de gestió de tarifesDescompte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(FactModuleConfig.API_PATH + "/tarifesDescompte")
public class TarifaDescompteApiController extends AbstractIdentificableWithIdentificadorApiController<TarifaDescompte> {

}
