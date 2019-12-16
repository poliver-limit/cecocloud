/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.facturacio.logic.api.dto.ArticleGamma;
import es.limit.cecocloud.facturacio.logic.api.service.ArticleGammaService;
import es.limit.cecocloud.facturacio.persist.entity.ArticleGammaEntity;

/**
 * Implementació del servei de gestió de articles gamma.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ArticleGammaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<ArticleGamma, ArticleGammaEntity, String> implements ArticleGammaService {

}
