/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleInformacio;
import es.limit.cecocloud.ecom.persist.entity.ArticleInformacioEntity;

/**
 * Conversor cap a DTO de les entitats de tipus ArticleInformacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomArticleInformacioEntityToDtoConverter")
public class ArticleInformacioToDtoConverter extends AbstractEntityToDtoConverter<ArticleInformacioEntity, ArticleInformacio> {

}