/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.ZonaFact.ZonaFactPk;
import es.limit.cecocloud.facturacio.persist.entity.ZonaFactEntity;

/**
 * Repositori per a gestionar les entitats de tipus zona.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ZonaFactRepository")
public interface ZonaFactRepository extends BaseRepository<ZonaFactEntity, ZonaFactPk> {
}