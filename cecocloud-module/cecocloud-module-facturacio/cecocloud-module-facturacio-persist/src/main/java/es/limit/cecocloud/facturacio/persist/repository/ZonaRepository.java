/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.cecogest.comu.persist.repository.BaseRepository;
import es.limit.cecogest.facturacio.logic.api.dto.Zona.ZonaPk;
import es.limit.cecogest.facturacio.persist.entity.ZonaEntity;

/**
 * Mètodes necessaris per a gestionar una entitat de base
 * de dades de tipus zona.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("factZonaRepository")
public interface ZonaRepository extends BaseRepository<ZonaEntity, ZonaPk> {
}