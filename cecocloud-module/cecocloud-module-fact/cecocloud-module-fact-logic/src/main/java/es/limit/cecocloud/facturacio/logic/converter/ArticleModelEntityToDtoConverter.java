/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.ArticleModel;
import es.limit.cecocloud.facturacio.persist.entity.ArticleModelEntity;

/**
 * Conversor cap a DTO de les entitats de tipus ArticleModel.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class ArticleModelEntityToDtoConverter extends AbstractEntityToDtoConverter<ArticleModelEntity, ArticleModel> {

}