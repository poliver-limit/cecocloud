/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.Vehicle;
import es.limit.cecocloud.fact.persist.entity.VehicleEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Vehicle.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class VehicleEntityToDtoConverter extends AbstractEntityToDtoConverter<VehicleEntity, Vehicle> {

}