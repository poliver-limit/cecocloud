/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.persist.entity.PaisNifEntity;

/**
 * Repository per a gestionar les entitats de PaisNif.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("factPaisNifRepository")
public interface PaisNifRepository extends BaseRepository<PaisNifEntity, String> {

}
