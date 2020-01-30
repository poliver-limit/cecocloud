/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.persist.entity.PaisNifEntity;

/**
 * Repository per a gestionar les entitats de PaisNif.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("factPaisNifRepository")
public interface PaisNifRepository extends BaseRepository<PaisNifEntity, String> {

}
