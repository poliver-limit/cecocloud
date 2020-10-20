/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.Taller;
import es.limit.cecocloud.fact.persist.entity.TallerEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Taller.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class TallerEntityToDtoConverter extends AbstractEntityToDtoConverter<TallerEntity, Taller> {

}