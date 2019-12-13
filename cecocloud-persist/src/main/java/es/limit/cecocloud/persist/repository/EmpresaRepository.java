/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.EmpresaEntity;

/**
 * Repository per a gestionar les entitats de tipus empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface EmpresaRepository extends BaseRepository<EmpresaEntity, Long> {

}
