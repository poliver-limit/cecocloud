/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.MagatzemArticle;
import es.limit.cecocloud.ecom.persist.entity.MagatzemArticleEntity;

/**
 * Conversor cap a DTO de les entitats de tipus MagatzemArticle.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomMagatzemArticleEntityToDtoConverter")
public class MagatzemArticleEntityToDtoConverter extends AbstractEntityToDtoConverter<MagatzemArticleEntity, MagatzemArticle> {

}