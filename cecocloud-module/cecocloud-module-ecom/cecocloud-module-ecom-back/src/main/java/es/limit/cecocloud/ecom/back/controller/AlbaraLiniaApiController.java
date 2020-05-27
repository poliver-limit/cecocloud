/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.AlbaraLinia;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de AlbaraLinia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomAlbaraLiniaController")
@RequestMapping(EcomModuleConfig.API_PATH + "/albaransLinia")
public class AlbaraLiniaApiController extends AbstractIdentificableWithIdentificadorApiController<AlbaraLinia> {

}
