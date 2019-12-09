/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.Calendari.CalendariPk;
import es.limit.cecocloud.rrhh.persist.entity.CalendariEntity;

/**
 * Repositori per a gestionar les entitats de tipus Calendari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface CalendariRepository extends BaseRepository<CalendariEntity, CalendariPk> {
}