/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.PuntVenda;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de PuntVenda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomPuntVendaController")
@RequestMapping(EcomModuleConfig.API_PATH + "/puntsVenda")
public class PuntVendaApiController extends AbstractIdentificableWithIdentificadorApiController<PuntVenda> {

}
