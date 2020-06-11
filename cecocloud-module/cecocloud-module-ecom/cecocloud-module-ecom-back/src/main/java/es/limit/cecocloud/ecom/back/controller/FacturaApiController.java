/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.Factura;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de Factura.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomFacturaController")
@RequestMapping(EcomModuleConfig.API_PATH + "/factures")
public class FacturaApiController extends AbstractIdentificableWithIdentificadorApiController<Factura> {

}
