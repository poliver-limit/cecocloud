/**
 * 
 */
package es.limit.cecocloud.ecom.back.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.PuntVenda;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de articles.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomPuntVendaEcommerceController")
@RequestMapping(EcomModuleConfig.API_ECOMMERCE_PATH + "/puntvenda")
public class PuntVentaEcomApiController extends AbstractIdentificableWithIdentificadorApiController<PuntVenda> {
	


}