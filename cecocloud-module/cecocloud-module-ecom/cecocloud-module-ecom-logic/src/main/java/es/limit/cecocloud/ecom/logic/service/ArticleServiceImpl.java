/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.logic.api.dto.Article;
import es.limit.cecocloud.ecom.logic.api.service.ArticleService;
import es.limit.cecocloud.ecom.persist.entity.ArticleEntity;

/**
 * Implementació del servei de gestió de articles.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomArticleService")
public class ArticleServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Article, ArticleEntity, String> implements ArticleService {

}
