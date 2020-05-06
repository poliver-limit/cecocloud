/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.Article;
import es.limit.cecocloud.ecom.persist.entity.ArticleEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Article.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomArticleEntityToDtoConverter")
public class ArticleEntityToDtoConverter extends AbstractEntityToDtoConverter<ArticleEntity, Article> {

}