/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.ArticleGamma;
import es.limit.cecocloud.fact.logic.api.service.ArticleGammaService;
import es.limit.cecocloud.fact.persist.entity.ArticleGammaEntity;

/**
 * Implementació del servei de gestió de articles gamma.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ArticleGammaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<ArticleGamma, ArticleGammaEntity, String> implements ArticleGammaService {

}
