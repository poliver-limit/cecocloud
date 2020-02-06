/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.entity.OperariEntity;

/**
 * Repository per a gestionar les entitats de tipus operari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface OperariRepository extends BaseRepository<OperariEntity, Long> {

	List<OperariEntity> findByIdentificador(IdentificadorEntity identificador);

	Optional<OperariEntity> findByIdentificadorAndEmbeddedCodi(IdentificadorEntity identificador, String codi);

	Optional<OperariEntity> findByIdentificadorAndEmbeddedActiuAndUsuariEmbeddedCodi(
			IdentificadorEntity identificador,
			boolean actiu,
			String usuariCodi);

	List<OperariEntity> findByUsuariEmbeddedCodiAndEmbeddedActiu(String usuariCodi, boolean actiu);

}
