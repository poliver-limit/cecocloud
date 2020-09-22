/**
 * 
 */
package es.limit.cecocloud.marc.persist.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.marc.persist.entity.LlocFeinaEntity;
import es.limit.cecocloud.persist.entity.OperariEmpresaEntity;

/**
 * Repository per a gestionar l'entitat de configuració.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface LlocFeinaRepository extends BaseRepository<LlocFeinaEntity, Long>{

	@Query(	"select" +
			"    oellf.llocFeina " +
			"from" +
			"    OperariEmpresaLlocFeinaEntity oellf " +
			"where " +
			"    oellf.operariEmpresa = : operariEmpresa")
	Set<LlocFeinaEntity> findByOperariEmpresa(OperariEmpresaEntity operariEmpresa);

}
