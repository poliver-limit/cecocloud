/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.CategoriaTraduccio;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de CategoriaTraduccio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomCategoriaTraduccioController")
@RequestMapping(EcomModuleConfig.API_PATH + "/categoriesTraduccio")
public class CategoriaTraduccioApiController extends AbstractIdentificableWithIdentificadorApiController<CategoriaTraduccio> {

}
