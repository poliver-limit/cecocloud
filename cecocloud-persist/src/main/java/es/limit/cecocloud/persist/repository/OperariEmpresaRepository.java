/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.entity.OperariEmpresaEntity;
import es.limit.cecocloud.persist.entity.OperariEntity;

/**
 * Repository per a gestionar les entitats de tipus operari-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface OperariEmpresaRepository extends BaseRepository<OperariEmpresaEntity, Long> {

	List<OperariEmpresaEntity> findByOperari(OperariEntity operari);

	List<OperariEmpresaEntity> findByEmpresa(EmpresaEntity empresa);

	List<OperariEmpresaEntity> findByOperariInAndEmbeddedActiuAndEmpresaEmbeddedActiva(
			List<OperariEntity> operaris,
			boolean actiu,
			boolean empresaActiva);

	Optional<OperariEmpresaEntity> findByOperariAndEmpresa(OperariEntity operari, EmpresaEntity empresa);

	Optional<OperariEmpresaEntity> findByOperariAndEmpresaAndEmbeddedActiu(
			OperariEntity operari,
			EmpresaEntity empresa,
			boolean actiu);

	Optional<OperariEmpresaEntity> findByOperariIdentificadorAndOperariEmbeddedActiuAndOperariUsuariEmbeddedCodiAndEmpresaAndEmpresaEmbeddedActiva(
			IdentificadorEntity identificador,
			boolean actiu,
			String usuariCodi,
			EmpresaEntity empresa,
			boolean activa);

}
