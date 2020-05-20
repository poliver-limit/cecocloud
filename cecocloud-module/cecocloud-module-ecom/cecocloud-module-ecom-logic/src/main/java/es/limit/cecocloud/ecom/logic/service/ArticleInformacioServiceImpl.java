/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleInformacio;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleInformacio.ArticleInformacioPk;
import es.limit.cecocloud.ecom.logic.api.service.ArticleInformacioService;
import es.limit.cecocloud.ecom.persist.entity.ArticleInformacioEntity;

/**
 * Implementació del servei de gestió de registres comercials.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ArticleInformacioServiceImpl extends AbstractGenericCompositePkServiceImpl<ArticleInformacio, ArticleInformacioEntity, ArticleInformacioPk> implements ArticleInformacioService {

	@Override
	protected ArticleInformacioPk getPkFromDto(ArticleInformacio dto) {				
		return new ArticleInformacioPk(
				dto.getIdentificador().getId(),
				dto.getArticle().getPk().getCodi(),				
				dto.getReferenciaSequencial());
	}

}
