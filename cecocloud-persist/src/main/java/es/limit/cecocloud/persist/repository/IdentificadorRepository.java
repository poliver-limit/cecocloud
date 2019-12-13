/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;

/**
 * Repository per a gestionar les entitats de tipus identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface IdentificadorRepository extends BaseRepository<IdentificadorEntity, String> {

	Optional<IdentificadorEntity> findByEmbeddedCodi(String codi);

}
