/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.Vehicle.VehiclePk;
import es.limit.cecocloud.facturacio.persist.entity.VehicleEntity;

/**
 * Repositori per a gestionar les entitats de tipus zona.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface VehicleRepository extends BaseRepository<VehicleEntity, VehiclePk> {
}