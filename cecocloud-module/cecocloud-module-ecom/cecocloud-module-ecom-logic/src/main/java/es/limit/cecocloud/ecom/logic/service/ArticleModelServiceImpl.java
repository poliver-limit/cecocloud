/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.logic.api.dto.ArticleModel;
import es.limit.cecocloud.ecom.logic.api.service.ArticleModelService;
import es.limit.cecocloud.ecom.persist.entity.ArticleModelEntity;

/**
 * Implementació del servei de gestió de articles model.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomArticleModelService")
public class ArticleModelServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<ArticleModel, ArticleModelEntity, String> implements ArticleModelService {

}
