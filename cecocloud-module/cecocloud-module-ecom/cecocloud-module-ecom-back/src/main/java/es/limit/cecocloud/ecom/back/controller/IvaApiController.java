/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.Iva;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de iva.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomIvaController")
@RequestMapping(EcomModuleConfig.API_PATH + "/ives")
public class IvaApiController extends AbstractIdentificableWithIdentificadorApiController<Iva> {

}
