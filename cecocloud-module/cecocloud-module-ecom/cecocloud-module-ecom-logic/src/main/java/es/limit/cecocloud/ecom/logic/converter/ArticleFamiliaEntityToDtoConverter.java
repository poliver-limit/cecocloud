/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleFamilia;
import es.limit.cecocloud.ecom.persist.entity.ArticleFamiliaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus ArticleFamilia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomArticleFamiliaEntityToDtoConverter")
public class ArticleFamiliaEntityToDtoConverter extends AbstractEntityToDtoConverter<ArticleFamiliaEntity, ArticleFamilia> {

}