/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificador.UsuariIdentificadorPk;
import es.limit.cecocloud.persist.entity.UsuariIdentificadorEntity;

/**
 * Repository per a gestionar les entitats de tipus usuari-identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface UsuariIdentificadorRepository extends BaseRepository<UsuariIdentificadorEntity, UsuariIdentificadorPk> {

	List<UsuariIdentificadorEntity> findByUsuariEmbeddedCodiOrderByCompanyiaEmbeddedNom(String usuariCodi);

}
