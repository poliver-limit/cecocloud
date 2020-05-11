/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.ArticleInformacio;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de articlesInformacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomArticleInformacioController")
@RequestMapping(EcomModuleConfig.API_PATH + "/articlesInformacio")
public class ArticleInformacioApiController extends AbstractIdentificableWithIdentificadorApiController<ArticleInformacio> {

}
