/**
 * 
 */
package es.limit.cecocloud.ecom.back.ecommerce.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.back.ecommerce.logic.api.dto.ArticleEcom;
import es.limit.cecocloud.ecom.back.ecommerce.persist.entity.ArticleEcomEntity;
/**
 * Conversor cap a DTO de les entitats de tipus Article.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomArticleEcomEntityToDtoConverter")
public class ArticleEcomEntityToDtoConverter extends AbstractEntityToDtoConverter<ArticleEcomEntity, ArticleEcom> {

}