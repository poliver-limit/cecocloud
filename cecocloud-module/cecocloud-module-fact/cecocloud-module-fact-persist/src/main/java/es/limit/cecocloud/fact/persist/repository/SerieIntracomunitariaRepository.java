/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.SerieIntracomunitaria.SerieIntracomunitariaPk;
import es.limit.cecocloud.fact.persist.entity.SerieIntracomunitariaEntity;

/**
 * Repositori per a gestionar les entitats de tipus SerieIntracomunitaria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface SerieIntracomunitariaRepository extends BaseRepository<SerieIntracomunitariaEntity, SerieIntracomunitariaPk> {
}