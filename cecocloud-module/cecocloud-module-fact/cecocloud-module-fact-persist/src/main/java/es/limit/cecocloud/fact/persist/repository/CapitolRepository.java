/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.Capitol.CapitolPk;
import es.limit.cecocloud.fact.persist.entity.CapitolEntity;

/**
 * Repositori per a gestionar les entitats de tipus Capitol.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface CapitolRepository extends BaseRepository<CapitolEntity, CapitolPk> {
}