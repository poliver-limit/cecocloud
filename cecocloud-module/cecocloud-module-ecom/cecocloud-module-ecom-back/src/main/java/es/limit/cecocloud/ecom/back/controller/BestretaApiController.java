/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.Bestreta;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de Bestreta.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomBestretaController")
@RequestMapping(EcomModuleConfig.API_PATH + "/bestretes")
public class BestretaApiController extends AbstractIdentificableWithIdentificadorApiController<Bestreta> {

}
