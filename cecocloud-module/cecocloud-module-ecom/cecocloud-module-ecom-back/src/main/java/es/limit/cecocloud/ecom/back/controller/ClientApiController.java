/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.Client;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de Client.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomClientController")
@RequestMapping(EcomModuleConfig.API_PATH + "/clients")
public class ClientApiController extends AbstractIdentificableWithIdentificadorApiController<Client> {

}
