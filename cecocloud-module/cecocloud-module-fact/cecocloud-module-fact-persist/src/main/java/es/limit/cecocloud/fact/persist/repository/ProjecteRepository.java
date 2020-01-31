/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.Projecte.ProjectePk;
import es.limit.cecocloud.fact.persist.entity.ProjecteEntity;

/**
 * Repositori per a gestionar les entitats de Projecte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

public interface ProjecteRepository extends BaseRepository<ProjecteEntity, ProjectePk> {

}
