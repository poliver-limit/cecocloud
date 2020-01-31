/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.Tarifa;
import es.limit.cecocloud.fact.persist.entity.TarifaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Tarifa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class TarifaEntityToDtoConverter extends AbstractEntityToDtoConverter<TarifaEntity, Tarifa> {

}