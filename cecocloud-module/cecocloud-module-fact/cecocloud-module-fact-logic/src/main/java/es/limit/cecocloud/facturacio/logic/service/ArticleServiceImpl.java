/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.Article;
import es.limit.cecocloud.facturacio.logic.api.dto.Article.ArticlePk;
import es.limit.cecocloud.facturacio.logic.api.service.ArticleService;
import es.limit.cecocloud.facturacio.persist.entity.ArticleEntity;

/**
 * Implementació del servei de gestió de articles.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ArticleServiceImpl extends AbstractGenericCompositePkServiceImpl<Article, ArticleEntity, ArticlePk> implements ArticleService {

	@Override
	protected ArticlePk getPkFromDto(Article dto) {
		return new ArticlePk(
				dto.getIdentificador().getId(),				
				dto.getCodi());
	}


}
