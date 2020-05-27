/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.Albara;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de albarans.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomAlbaraController")
@RequestMapping(EcomModuleConfig.API_PATH + "/albarans")
public class AlbaraApiController extends AbstractIdentificableWithIdentificadorApiController<Albara> {

}
