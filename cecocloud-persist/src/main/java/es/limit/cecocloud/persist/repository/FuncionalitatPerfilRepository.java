/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.FuncionalitatPerfilEntity;

/**
 * Repository per a gestionar les entitats de tipus funcionalitat-perfil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface FuncionalitatPerfilRepository extends BaseRepository<FuncionalitatPerfilEntity, Long> {

	List<FuncionalitatPerfilEntity> findByPerfilIdOrderByFuncionalitatEmbeddedDescripcio(Long perfilId);
	List<FuncionalitatPerfilEntity> findByPerfilIdInOrderByFuncionalitatEmbeddedDescripcio(List<Long> perfilId);
}
