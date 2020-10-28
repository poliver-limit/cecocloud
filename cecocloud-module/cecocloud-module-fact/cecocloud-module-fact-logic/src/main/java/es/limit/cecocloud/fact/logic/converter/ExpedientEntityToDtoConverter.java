/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.Expedient;
import es.limit.cecocloud.fact.persist.entity.ExpedientEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Expedient.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class ExpedientEntityToDtoConverter extends AbstractEntityToDtoConverter<ExpedientEntity, Expedient> {

}