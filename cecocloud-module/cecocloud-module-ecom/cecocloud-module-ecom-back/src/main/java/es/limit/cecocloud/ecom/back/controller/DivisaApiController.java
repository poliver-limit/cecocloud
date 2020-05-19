/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.Divisa;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de Divises.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomDivisaController")
@RequestMapping(EcomModuleConfig.API_PATH + "/divises")
public class DivisaApiController extends AbstractIdentificableWithIdentificadorApiController<Divisa> {

}
