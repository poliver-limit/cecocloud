/**
 * 
 */
package es.limit.cecocloud.ecom.back.ecommerce.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.back.ecommerce.logic.api.dto.ArticleEcom;
import es.limit.cecocloud.ecom.back.ecommerce.logic.api.service.ArticleEcomService;
import es.limit.cecocloud.ecom.back.ecommerce.persist.entity.ArticleEcomEntity;
import es.limit.cecocloud.ecom.logic.service.AbstractAmbIdentificadorICodiServiceImpl;

/**
 * Implementació del servei de gestió de articles.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomBackArticleService")
public class ArticleEcomServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<ArticleEcom, ArticleEcomEntity, String> implements ArticleEcomService {

	

}
