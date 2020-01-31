/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.Ubicacio.UbicacioPk;
import es.limit.cecocloud.fact.persist.entity.UbicacioEntity;

/**
 * Repositori per a gestionar les entitats de tipus Ubicacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface UbicacioRepository extends BaseRepository<UbicacioEntity, UbicacioPk> {
}