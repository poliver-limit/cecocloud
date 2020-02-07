/**
 * 
 */
package es.limit.cecocloud.lici.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.lici.persist.entity.ConfiguracioEntity;

/**
 * Repository per a gestionar l'entitat de configuració.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

@Repository
public interface ConfiguracioRepository extends BaseRepository<ConfiguracioEntity, Long>{
	
	
}
