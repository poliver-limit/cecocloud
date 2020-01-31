/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.ArticleMarca;
import es.limit.cecocloud.fact.persist.entity.ArticleMarcaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus ArticleMarca.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class ArticleMarcaEntityToDtoConverter extends AbstractEntityToDtoConverter<ArticleMarcaEntity, ArticleMarca> {

}