/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleTraduccio;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleTraduccio.ArticleTraduccioPk;
import es.limit.cecocloud.ecom.logic.api.service.ArticleTraduccioService;
import es.limit.cecocloud.ecom.persist.entity.ArticleTraduccioEntity;


/**
 * Implementació del servei de gestió de articles traduccio
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomArticleTraduccioService")
public class ArticleTraduccioServiceImpl extends AbstractGenericCompositePkServiceImpl<ArticleTraduccio, ArticleTraduccioEntity, ArticleTraduccioPk> implements ArticleTraduccioService {
	
	@Override
	protected ArticleTraduccioPk getPkFromDto(ArticleTraduccio dto) {	
		return new ArticleTraduccioPk(
				dto.getIdentificador().getId(),				
				dto.getArticle().getPk().getCodi(),
				dto.getIdioma().getPk().getCodi());
	}

}
