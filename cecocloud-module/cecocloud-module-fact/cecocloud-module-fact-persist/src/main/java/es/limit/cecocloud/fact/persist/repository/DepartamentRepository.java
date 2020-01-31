/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.Departament.DepartamentPk;
import es.limit.cecocloud.fact.persist.entity.DepartamentEntity;

/**
 * Repositori per a gestionar les entitats de tipus Departament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface DepartamentRepository extends BaseRepository<DepartamentEntity, DepartamentPk> {
}