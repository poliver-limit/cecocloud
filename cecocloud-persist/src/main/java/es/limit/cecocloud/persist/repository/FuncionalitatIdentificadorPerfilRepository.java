/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.FuncionalitatIdentificadorEntity;
import es.limit.cecocloud.persist.entity.FuncionalitatIdentificadorPerfilEntity;
import es.limit.cecocloud.persist.entity.PerfilEntity;

/**
 * Repository per a gestionar les entitats de tipus funcionalitat-perfil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface FuncionalitatIdentificadorPerfilRepository extends BaseRepository<FuncionalitatIdentificadorPerfilEntity, Long> {

	FuncionalitatIdentificadorPerfilEntity findByPerfilAndFuncionalitatIdentificadorAndEmbeddedPermis(PerfilEntity perfil, FuncionalitatIdentificadorEntity funcionalitat, String permis);
	List<FuncionalitatIdentificadorPerfilEntity> findByPerfilIdAndFuncionalitatIdentificadorId(Long perfilId, Long funcionalitatId);
	List<FuncionalitatIdentificadorPerfilEntity> findByPerfilIdOrderByFuncionalitatIdentificadorFuncionalitatEmbeddedDescripcio(Long perfilId);
	List<FuncionalitatIdentificadorPerfilEntity> findByPerfilIdInOrderByFuncionalitatIdentificadorFuncionalitatEmbeddedDescripcio(List<Long> perfilId);
	
}
