/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.logic.api.dto.ArticleGamma;
import es.limit.cecocloud.ecom.logic.api.service.ArticleGammaService;
import es.limit.cecocloud.ecom.persist.entity.ArticleGammaEntity;

/**
 * Implementació del servei de gestió de articles gamma.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomArticleGammaService")
public class ArticleGammaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<ArticleGamma, ArticleGammaEntity, String> implements ArticleGammaService {

}
