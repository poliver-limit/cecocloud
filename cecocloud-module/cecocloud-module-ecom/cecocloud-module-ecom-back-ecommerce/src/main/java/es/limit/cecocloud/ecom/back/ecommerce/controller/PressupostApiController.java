/**
 * 
 */
package es.limit.cecocloud.ecom.back.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.Pressupost;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de articles.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomPressupostEcommerceController")
@RequestMapping(EcomModuleConfig.API_ECOMMERCE_PATH + "/pressupost")
public class PressupostApiController extends AbstractIdentificableWithIdentificadorApiController<Pressupost> {

}