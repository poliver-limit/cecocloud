/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.Vehicle;
import es.limit.cecocloud.facturacio.logic.api.dto.Vehicle.VehiclePk;
import es.limit.cecocloud.facturacio.logic.api.service.VehicleService;
import es.limit.cecocloud.facturacio.persist.entity.VehicleEntity;

/**
 * Implementació del servei de gestió de vehicles.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class VehicleServiceImpl extends AbstractGenericCompositePkServiceImpl<Vehicle, VehicleEntity, VehiclePk> implements VehicleService {

	@Override
	protected VehiclePk getPkFromDto(Vehicle dto) {
		return new VehiclePk(
				dto.getIdentificador().getId(),
				dto.getCodi());				
	}

}
