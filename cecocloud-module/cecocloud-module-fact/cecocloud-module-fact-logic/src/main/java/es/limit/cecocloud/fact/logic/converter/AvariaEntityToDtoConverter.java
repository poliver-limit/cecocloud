/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.Avaria;
import es.limit.cecocloud.fact.persist.entity.AvariaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Avaria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class AvariaEntityToDtoConverter extends AbstractEntityToDtoConverter<AvariaEntity, Avaria> {

}