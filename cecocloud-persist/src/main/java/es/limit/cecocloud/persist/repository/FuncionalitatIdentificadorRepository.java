/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.FuncionalitatEntity;
import es.limit.cecocloud.persist.entity.FuncionalitatIdentificadorEntity;

/**
 * Repository per a gestionar les entitats de tipus funcionalitat-identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface FuncionalitatIdentificadorRepository extends BaseRepository<FuncionalitatIdentificadorEntity, Long> {

	List<FuncionalitatEntity> findFuncionalitatByIdentificadorIdOrderByFuncionalitatEmbeddedDescripcio(Long identificadorId);
	
}
