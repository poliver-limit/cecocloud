/**
 * 
 */
package es.limit.cecocloud.fact.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.fact.logic.api.dto.LiniaEstudi;
import es.limit.cecocloud.fact.logic.api.module.FactModuleConfig;

/**
 * Controlador per al servei REST de gestió de LiniaEstudi.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("factLiniaEstudiApiController")
@RequestMapping(FactModuleConfig.API_PATH + "/liniaEstudi")
public class LiniaEstudiApiController extends AbstractIdentificableWithIdentificadorApiController<LiniaEstudi> {

}
