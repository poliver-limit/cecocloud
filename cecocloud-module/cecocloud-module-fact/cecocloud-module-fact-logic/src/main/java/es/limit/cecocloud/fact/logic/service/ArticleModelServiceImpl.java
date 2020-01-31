/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.ArticleModel;
import es.limit.cecocloud.fact.logic.api.service.ArticleModelService;
import es.limit.cecocloud.fact.persist.entity.ArticleModelEntity;

/**
 * Implementació del servei de gestió de articles model.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ArticleModelServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<ArticleModel, ArticleModelEntity, String> implements ArticleModelService {

}
