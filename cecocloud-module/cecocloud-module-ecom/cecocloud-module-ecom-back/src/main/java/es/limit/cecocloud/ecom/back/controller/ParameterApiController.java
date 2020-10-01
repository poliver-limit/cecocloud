/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.Parameter;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controller for parameters REST service.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomParameterApicontroller")
@RequestMapping(EcomModuleConfig.API_PATH + "/parameters")
public class ParameterApiController extends AbstractIdentificableWithIdentificadorApiController<Parameter> {

}
