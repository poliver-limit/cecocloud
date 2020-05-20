/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.ArticleGamma;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de articlesGamma.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomArticleGammaController")
@RequestMapping(EcomModuleConfig.API_PATH + "/articlesGamma")
public class ArticleGammaApiController extends AbstractIdentificableWithIdentificadorApiController<ArticleGamma> {

}
