/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.SerieVenda;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de SerieVenda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomSerieVendaController")
@RequestMapping(EcomModuleConfig.API_PATH + "/seriesVenda")
public class SerieVendaApiController extends AbstractIdentificableWithIdentificadorApiController<SerieVenda> {

}
