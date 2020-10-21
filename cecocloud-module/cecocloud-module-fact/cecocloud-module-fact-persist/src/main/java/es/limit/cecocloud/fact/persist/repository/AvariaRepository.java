/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.Avaria.AvariaPk;
import es.limit.cecocloud.fact.persist.entity.AvariaEntity;

/**
 * Repositori per a gestionar les entitats de tipus Avaria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("factAvariaRepository")
public interface AvariaRepository extends BaseRepository<AvariaEntity, AvariaPk> {
}