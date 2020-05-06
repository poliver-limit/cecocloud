/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleModel;
import es.limit.cecocloud.ecom.persist.entity.ArticleModelEntity;

/**
 * Conversor cap a DTO de les entitats de tipus ArticleModel.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomArticleModelEntityToDtoConverter")
public class ArticleModelEntityToDtoConverter extends AbstractEntityToDtoConverter<ArticleModelEntity, ArticleModel> {

}