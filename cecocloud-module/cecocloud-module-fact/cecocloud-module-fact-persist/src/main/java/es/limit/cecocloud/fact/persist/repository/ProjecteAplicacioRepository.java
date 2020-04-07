/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.ProjecteAplicacio.ProjecteAplicacioPk;
import es.limit.cecocloud.fact.persist.entity.ProjecteAplicacioEntity;

/**
 * Repositori per a gestionar les entitats de tipus ProjecteAplicacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface ProjecteAplicacioRepository extends BaseRepository<ProjecteAplicacioEntity, ProjecteAplicacioPk> {
}