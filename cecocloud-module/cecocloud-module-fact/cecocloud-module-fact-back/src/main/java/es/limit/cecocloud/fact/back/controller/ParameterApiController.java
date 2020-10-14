/**
 * 
 */
package es.limit.cecocloud.fact.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.fact.logic.api.dto.Parameter;
import es.limit.cecocloud.fact.logic.api.module.FactModuleConfig;

/**
 * Controller for parameters REST service.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("factParameterApicontroller")
@RequestMapping(FactModuleConfig.API_PATH + "/parameters")
public class ParameterApiController extends AbstractIdentificableWithIdentificadorApiController<Parameter> {

}
