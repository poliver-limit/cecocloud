/**
 * 
 */
package es.limit.cecocloud.fact.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.fact.logic.api.dto.UnitatControlEstudi;
import es.limit.cecocloud.fact.logic.api.module.FactModuleConfig;

/**
 * Controlador per al servei REST de gestió de UnitatControlEstudi.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("factUnitatControlEstudiApiController")
@RequestMapping(FactModuleConfig.API_PATH + "/unitatsControlEstudi")
public class UnitatControlEstudiApiController extends AbstractIdentificableWithIdentificadorApiController<UnitatControlEstudi> {

}
