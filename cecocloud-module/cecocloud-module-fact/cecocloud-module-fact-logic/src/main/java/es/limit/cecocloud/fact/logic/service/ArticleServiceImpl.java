/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.Article;
import es.limit.cecocloud.fact.logic.api.service.ArticleService;
import es.limit.cecocloud.fact.persist.entity.ArticleEntity;

/**
 * Implementació del servei de gestió de articles.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ArticleServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Article, ArticleEntity, String> implements ArticleService {

}
