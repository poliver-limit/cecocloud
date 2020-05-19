/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.PressupostLinia;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de PressupostLinia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomPressupostLiniaController")
@RequestMapping(EcomModuleConfig.API_PATH + "/pressupostosLinia")
public class PressupostLiniaApiController extends AbstractIdentificableWithIdentificadorApiController<PressupostLinia> {

}
