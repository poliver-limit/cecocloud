/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.ArticleFamilia;
import es.limit.cecocloud.facturacio.persist.entity.ArticleFamiliaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus ArticleFamilia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class ArticleFamiliaEntityToDtoConverter extends AbstractEntityToDtoConverter<ArticleFamiliaEntity, ArticleFamilia> {

}