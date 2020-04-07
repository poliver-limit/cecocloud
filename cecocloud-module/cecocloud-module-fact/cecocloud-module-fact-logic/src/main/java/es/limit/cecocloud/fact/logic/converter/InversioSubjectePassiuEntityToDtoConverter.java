/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.InversioSubjectePassiu;
import es.limit.cecocloud.fact.persist.entity.InversioSubjectePassiuEntity;

/**
 * Conversor cap a DTO de les entitats de tipus InversioSubjectePassiu.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class InversioSubjectePassiuEntityToDtoConverter extends AbstractEntityToDtoConverter<InversioSubjectePassiuEntity, InversioSubjectePassiu> {

}