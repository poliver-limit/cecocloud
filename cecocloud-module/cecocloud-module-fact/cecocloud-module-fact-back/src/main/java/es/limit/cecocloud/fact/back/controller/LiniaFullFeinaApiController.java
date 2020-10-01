/**
 * 
 */
package es.limit.cecocloud.fact.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.fact.logic.api.dto.LiniaFullFeina;
import es.limit.cecocloud.fact.logic.api.module.FactModuleConfig;

/**
 * Controlador per al servei REST de gestió de una linia full feina.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("factLiniaFullFeinaController")
@RequestMapping(FactModuleConfig.API_PATH + "/liniesFullFeina")
public class LiniaFullFeinaApiController extends AbstractIdentificableWithIdentificadorApiController<LiniaFullFeina> {

}
