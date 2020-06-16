/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.ecom.logic.api.dto.MagatzemArticle;
import es.limit.cecocloud.ecom.logic.api.dto.MagatzemArticle.MagatzemArticlePk;
import es.limit.cecocloud.ecom.logic.api.service.MagatzemArticleService;
import es.limit.cecocloud.ecom.persist.entity.MagatzemArticleEntity;

/**
 * Implementació del servei de gestió de articles familia empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomMagatzemArticleService")
public class MagatzemArticleServiceImpl extends AbstractGenericCompositePkServiceImpl<MagatzemArticle, MagatzemArticleEntity, MagatzemArticlePk> implements MagatzemArticleService {
	
	@Override
	protected MagatzemArticlePk getPkFromDto(MagatzemArticle dto) {
		return new MagatzemArticlePk(
				dto.getIdentificador().getId(),				
				dto.getMagatzem().getPk().getCodi(),//				
				dto.getArticle().getPk().getCodi());
	}

}
