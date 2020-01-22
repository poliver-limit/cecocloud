package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.Projecte.ProjectePk;
import es.limit.cecocloud.facturacio.persist.entity.ProjecteEntity;

/**
 * Repositori per a gestionar les entitats de Projecte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

public interface ProjecteRepository extends BaseRepository<ProjecteEntity, ProjectePk> {

}
