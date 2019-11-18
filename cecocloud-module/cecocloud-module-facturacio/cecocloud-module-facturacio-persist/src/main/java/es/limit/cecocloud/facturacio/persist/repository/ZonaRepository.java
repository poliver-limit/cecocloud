/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.Zona.ZonaPk;
import es.limit.cecocloud.facturacio.persist.entity.ZonaEntity;

/**
 * Repositori per a gestionar les entitats de tipus zona.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface ZonaRepository extends BaseRepository<ZonaEntity, ZonaPk> {
}