/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.ArticleModel;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de articlesModel.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomArticleModelController")
@RequestMapping(EcomModuleConfig.API_PATH + "/articlesModel")
public class ArticleModelApiController extends AbstractIdentificableWithIdentificadorApiController<ArticleModel> {

}
