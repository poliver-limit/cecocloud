/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleTraduccio;
import es.limit.cecocloud.ecom.persist.entity.ArticleTraduccioEntity;

/**
 * Conversor cap a DTO de les entitats de tipus ArticleTraduccio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomArticleTraduccioEntityToDtoConverter")
public class ArticleTraduccioEntityToDtoConverter extends AbstractEntityToDtoConverter<ArticleTraduccioEntity, ArticleTraduccio> {

}