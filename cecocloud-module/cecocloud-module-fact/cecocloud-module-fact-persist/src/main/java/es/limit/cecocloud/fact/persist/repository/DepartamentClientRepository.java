/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.DepartamentClient.DepartamentClientPk;
import es.limit.cecocloud.fact.persist.entity.DepartamentClientEntity;

/**
 * Repositori per a gestionar les entitats de tipus DepartamentClient.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface DepartamentClientRepository extends BaseRepository<DepartamentClientEntity, DepartamentClientPk> {
}