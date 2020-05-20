/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.SerieCompra;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de SerieCompra.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomSerieCompraController")
@RequestMapping(EcomModuleConfig.API_PATH + "/seriesCompra")
public class SerieCompraApiController extends AbstractIdentificableWithIdentificadorApiController<SerieCompra> {

}
