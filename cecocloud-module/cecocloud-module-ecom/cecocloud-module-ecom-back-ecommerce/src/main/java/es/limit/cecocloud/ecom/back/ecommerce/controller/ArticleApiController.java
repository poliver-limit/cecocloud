/**
 * 
 */
package es.limit.cecocloud.ecom.back.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.Article;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de articles.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomArticleEcommerceController")
@RequestMapping(EcomModuleConfig.API_ECOMMERCE_PATH + "/articles")
public class ArticleApiController extends AbstractIdentificableWithIdentificadorApiController<Article> {

}