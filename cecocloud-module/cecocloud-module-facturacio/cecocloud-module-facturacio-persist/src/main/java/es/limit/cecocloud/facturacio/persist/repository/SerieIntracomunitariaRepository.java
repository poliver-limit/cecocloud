/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.SerieIntracomunitaria.SerieIntracomunitariaPk;
import es.limit.cecocloud.facturacio.persist.entity.SerieIntracomunitariaEntity;

/**
 * Repositori per a gestionar les entitats de tipus SerieIntracomunitaria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface SerieIntracomunitariaRepository extends BaseRepository<SerieIntracomunitariaEntity, SerieIntracomunitariaPk> {
}