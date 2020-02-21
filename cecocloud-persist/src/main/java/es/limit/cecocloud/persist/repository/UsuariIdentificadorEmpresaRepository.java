/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;
import java.util.Optional;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.UsuariIdentificadorEmpresaEntity;
import es.limit.cecocloud.persist.entity.UsuariIdentificadorEntity;

/**
 * Repository per a gestionar les entitats de tipus (usuari-identificador)-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface UsuariIdentificadorEmpresaRepository extends BaseRepository<UsuariIdentificadorEmpresaEntity, Long> {

	Optional<UsuariIdentificadorEmpresaEntity> findByUsuariIdentificadorAndEmpresa(
			UsuariIdentificadorEntity usuariIdentificador,
			EmpresaEntity empresa);

	List<UsuariIdentificadorEmpresaEntity> findByUsuariIdentificadorUsuariEmbeddedCodiAndEmpresaIdentificadorIdOrderByEmpresaEmbeddedNom(
			String usuariCodi,
			Long identificadorId);

	List<UsuariIdentificadorEmpresaEntity> findByUsuariIdentificador(UsuariIdentificadorEntity usuariIdentificador);

}