/**
 * 
 */
package es.limit.cecocloud.cita.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.cita.logic.api.dto.Cita.CitaPk;
import es.limit.cecocloud.cita.persist.entity.CitaEntity;

/**
 * Repositori per a gestionar les entitats de tipus cita.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface CitaRepository extends BaseRepository<CitaEntity, CitaPk> {
}