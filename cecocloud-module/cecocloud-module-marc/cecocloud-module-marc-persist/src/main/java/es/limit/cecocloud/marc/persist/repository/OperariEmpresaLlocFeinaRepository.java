/**
 * 
 */
package es.limit.cecocloud.marc.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.marc.persist.entity.OperariEmpresaLlocFeinaEntity;

/**
 * Repository per a gestionar l'entitat amb les relacions (operari-empresa)-(lloc de feina).
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface OperariEmpresaLlocFeinaRepository extends BaseRepository<OperariEmpresaLlocFeinaEntity, Long>{

}
