/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.ArticleGamma;
import es.limit.cecocloud.facturacio.logic.api.dto.ArticleGamma.ArticleGammaPk;
import es.limit.cecocloud.facturacio.logic.api.service.ArticleGammaService;
import es.limit.cecocloud.facturacio.persist.entity.ArticleGammaEntity;

/**
 * Implementació del servei de gestió de articles gamma.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ArticleGammaServiceImpl extends AbstractGenericCompositePkServiceImpl<ArticleGamma, ArticleGammaEntity, ArticleGammaPk> implements ArticleGammaService {

	@Override
	protected ArticleGammaPk getPkFromDto(ArticleGamma dto) {
		return new ArticleGammaPk(
				dto.getIdentificador().getId(),				
				dto.getCodi());
	}


}
