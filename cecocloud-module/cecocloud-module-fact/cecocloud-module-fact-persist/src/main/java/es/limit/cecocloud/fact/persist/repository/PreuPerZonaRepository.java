/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.PreuPerZona.PreuPerZonaPk;
import es.limit.cecocloud.fact.persist.entity.PreuPerZonaEntity;

/**
 * Repositori per a gestionar les entitats de tipus PreuPerZona.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("factPreuPerZonaRepository")
public interface PreuPerZonaRepository extends BaseRepository<PreuPerZonaEntity, PreuPerZonaPk> {
}