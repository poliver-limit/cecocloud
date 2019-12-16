/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.UbicacioArticle;
import es.limit.cecocloud.facturacio.persist.entity.UbicacioArticleEntity;

/**
 * Conversor cap a DTO de les entitats de tipus UbicacioArticle.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class UbicacioArticleEntityToDtoConverter extends AbstractEntityToDtoConverter<UbicacioArticleEntity, UbicacioArticle> {

}