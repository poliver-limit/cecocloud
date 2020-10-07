/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.UnitatControlEstudi.UnitatControlEstudiPk;
import es.limit.cecocloud.fact.persist.entity.UnitatControlEstudiEntity;

/**
 * Repositori per a gestionar les entitats de tipus UnitatControlEstudi.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("factUnitatControlEstudiRepository")
public interface UnitatControlEstudiRepository extends BaseRepository<UnitatControlEstudiEntity, UnitatControlEstudiPk> {
}