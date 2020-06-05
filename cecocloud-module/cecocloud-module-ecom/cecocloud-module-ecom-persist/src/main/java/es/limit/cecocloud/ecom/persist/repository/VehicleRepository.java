/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.Vehicle.VehiclePk;
import es.limit.cecocloud.ecom.persist.entity.VehicleEntity;

/**
 * Repositori per a gestionar les entitats de tipus Vehicle.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomVehicleRepository")
public interface VehicleRepository extends BaseRepository<VehicleEntity, VehiclePk> {
}