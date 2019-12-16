/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.Vehicle;
import es.limit.cecocloud.facturacio.persist.entity.VehicleEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Vehicle.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class VehicleEntityToDtoConverter extends AbstractEntityToDtoConverter<VehicleEntity, Vehicle> {

}