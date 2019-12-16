/**
 * 
 */
package es.limit.cecocloud.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.logic.api.dto.CaracteristicaIdentificador;
import es.limit.cecocloud.persist.entity.CaracteristicaIdentificadorEntity;

/**
 * Conversor cap a DTO de les entitats de tipus característica-Identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class CaracteristicaIdentificadorEntityToDtoConverter extends AbstractEntityToDtoConverter<CaracteristicaIdentificadorEntity, CaracteristicaIdentificador> {

}