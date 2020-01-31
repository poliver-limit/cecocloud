/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.UbicacioArticle;
import es.limit.cecocloud.fact.logic.api.dto.UbicacioArticle.UbicacioArticlePk;
import es.limit.cecocloud.fact.logic.api.service.UbicacioArticleService;
import es.limit.cecocloud.fact.persist.entity.UbicacioArticleEntity;

/**
 * Implementació del servei de gestió de ubicacions article.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class UbicacioArticleServiceImpl extends AbstractGenericCompositePkServiceImpl<UbicacioArticle, UbicacioArticleEntity, UbicacioArticlePk> implements UbicacioArticleService {

	@Override
	protected UbicacioArticlePk getPkFromDto(UbicacioArticle dto) {
		return new UbicacioArticlePk(
				dto.getIdentificador().getId(),				
				dto.getArticle().getPk().getCodi(),
				dto.getMagatzem().getPk().getCodi());
	}


}
