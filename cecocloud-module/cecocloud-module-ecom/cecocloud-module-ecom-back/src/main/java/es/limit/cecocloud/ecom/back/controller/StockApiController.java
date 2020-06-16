/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.Stock;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de articlesFamiliaEmpresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomStockController")
@RequestMapping(EcomModuleConfig.API_PATH + "/stocks")
public class StockApiController extends AbstractIdentificableWithIdentificadorApiController<Stock> {

}
