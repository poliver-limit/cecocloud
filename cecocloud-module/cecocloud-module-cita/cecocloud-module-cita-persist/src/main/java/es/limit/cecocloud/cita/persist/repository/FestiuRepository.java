/**
 * 
 */
package es.limit.cecocloud.cita.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.cita.logic.api.dto.Festiu.FestiuPk;
import es.limit.cecocloud.cita.persist.entity.FestiuEntity;

/**
 * Repositori per a gestionar les entitats de tipus festiu.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface FestiuRepository extends BaseRepository<FestiuEntity, FestiuPk> {
}