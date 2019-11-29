/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.ArticleModel;
import es.limit.cecocloud.facturacio.logic.api.dto.ArticleModel.ArticleModelPk;
import es.limit.cecocloud.facturacio.logic.api.service.ArticleModelService;
import es.limit.cecocloud.facturacio.persist.entity.ArticleModelEntity;

/**
 * Implementació del servei de gestió de articles model.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ArticleModelServiceImpl extends AbstractGenericCompositePkServiceImpl<ArticleModel, ArticleModelEntity, ArticleModelPk> implements ArticleModelService {

	@Override
	protected ArticleModelPk getPkFromDto(ArticleModel dto) {
		return new ArticleModelPk(
				dto.getIdentificador().getId(),				
				dto.getCodi());
	}


}
