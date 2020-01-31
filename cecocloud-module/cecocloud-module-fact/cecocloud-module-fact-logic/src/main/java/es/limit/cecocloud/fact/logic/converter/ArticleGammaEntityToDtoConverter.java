/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.ArticleGamma;
import es.limit.cecocloud.fact.persist.entity.ArticleGammaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus ArticleGamma.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class ArticleGammaEntityToDtoConverter extends AbstractEntityToDtoConverter<ArticleGammaEntity, ArticleGamma> {

}