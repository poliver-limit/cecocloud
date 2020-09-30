/**
 * 
 */
package es.limit.cecocloud.fact.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.fact.logic.api.dto.ConfiguracioImpressos;
import es.limit.cecocloud.fact.logic.api.module.FactModuleConfig;

/**
 * Controller for configuracio d'impressos REST service.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(FactModuleConfig.API_PATH + "/configuracionsImpressos")
public class ConfiguracioImpressosApiController extends AbstractIdentificableWithIdentificadorApiController<ConfiguracioImpressos> {

}
