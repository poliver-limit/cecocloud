/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.ArticleTraduccio;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de articlesTraduccio
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomArticleTraduccioController")
@RequestMapping(EcomModuleConfig.API_PATH + "/articlesTraduccio")
public class ArticleTraduccioApiController extends AbstractIdentificableWithIdentificadorApiController<ArticleTraduccio> {

}
