/**
 * 
 */
package es.limit.cecocloud.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.logic.api.dto.Caracteristica;
import es.limit.cecocloud.persist.entity.CaracteristicaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus característica.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class CaracteristicaEntityToDtoConverter extends AbstractEntityToDtoConverter<CaracteristicaEntity, Caracteristica> {

}