/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.entity.UsuariEntity;
import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.entity.UsuariIdentificadorEntity;

/**
 * Repository per a gestionar les entitats de tipus usuari-identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface UsuariIdentificadorRepository extends BaseRepository<UsuariIdentificadorEntity, Long> {

	Optional<UsuariIdentificadorEntity> findByUsuariAndIdentificador(UsuariEntity usuari, IdentificadorEntity identificador);

	List<UsuariIdentificadorEntity> findByUsuariEmbeddedCodiOrderByIdentificadorEmbeddedDescripcio(String usuariCodi);

	List<UsuariIdentificadorEntity> findByIdentificador(IdentificadorEntity identificador);

}
