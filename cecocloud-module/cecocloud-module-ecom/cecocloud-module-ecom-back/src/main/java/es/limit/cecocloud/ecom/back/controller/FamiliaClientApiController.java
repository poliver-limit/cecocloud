/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.FamiliaClient;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de FamiliaClient.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomFamiliaClientController")
@RequestMapping(EcomModuleConfig.API_PATH + "/familiesClient")
public class FamiliaClientApiController extends AbstractIdentificableWithIdentificadorApiController<FamiliaClient> {

}
