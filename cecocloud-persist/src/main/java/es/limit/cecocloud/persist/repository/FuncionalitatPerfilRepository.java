/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.FuncionalitatEntity;
import es.limit.cecocloud.persist.entity.FuncionalitatPerfilEntity;
import es.limit.cecocloud.persist.entity.PerfilEntity;

/**
 * Repository per a gestionar les entitats de tipus funcionalitat-perfil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface FuncionalitatPerfilRepository extends BaseRepository<FuncionalitatPerfilEntity, Long> {

	FuncionalitatPerfilEntity findByPerfilAndFuncionalitatAndEmbeddedPermis(PerfilEntity perfil, FuncionalitatEntity funcionalitatId, String permis);
	List<FuncionalitatPerfilEntity> findByPerfilIdAndFuncionalitatId(Long perfilId, Long funcionalitatId);
	List<FuncionalitatPerfilEntity> findByPerfilIdOrderByFuncionalitatEmbeddedDescripcio(Long perfilId);
	List<FuncionalitatPerfilEntity> findByPerfilIdInOrderByFuncionalitatEmbeddedDescripcio(List<Long> perfilId);
	
}
