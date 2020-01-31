/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.Vehicle.VehiclePk;
import es.limit.cecocloud.fact.persist.entity.VehicleEntity;

/**
 * Repositori per a gestionar les entitats de tipus vehicle.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface VehicleRepository extends BaseRepository<VehicleEntity, VehiclePk> {
}