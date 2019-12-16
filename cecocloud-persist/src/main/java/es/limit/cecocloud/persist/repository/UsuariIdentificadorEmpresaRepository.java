/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresa.UsuariIdentificadorEmpresaPk;
import es.limit.cecocloud.persist.entity.UsuariIdentificadorEmpresaEntity;

/**
 * Repository per a gestionar les entitats de tipus (usuari-identificador)-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface UsuariIdentificadorEmpresaRepository extends BaseRepository<UsuariIdentificadorEmpresaEntity, UsuariIdentificadorEmpresaPk> {

	List<UsuariIdentificadorEmpresaEntity> findByUsuariIdentificadorUsuariEmbeddedCodiAndEmpresaIdentificadorIdOrderByEmpresaEmbeddedNom(
			String usuariCodi,
			Long identificadorId);

}