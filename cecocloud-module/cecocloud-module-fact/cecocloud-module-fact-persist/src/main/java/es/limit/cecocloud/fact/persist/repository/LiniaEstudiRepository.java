/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.LiniaEstudi.LiniaEstudiPk;
import es.limit.cecocloud.fact.persist.entity.LiniaEstudiEntity;

/**
 * Repositori per a gestionar les entitats de tipus LiniaEstudi.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("factLiniaEstudiRepository")
public interface LiniaEstudiRepository extends BaseRepository<LiniaEstudiEntity, LiniaEstudiPk> {
}