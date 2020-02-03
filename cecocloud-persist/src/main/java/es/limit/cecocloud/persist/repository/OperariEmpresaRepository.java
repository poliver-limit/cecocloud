/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.OperariEmpresaEntity;

/**
 * Repository per a gestionar les entitats de tipus operari-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface OperariEmpresaRepository extends BaseRepository<OperariEmpresaEntity, Long> {

}
