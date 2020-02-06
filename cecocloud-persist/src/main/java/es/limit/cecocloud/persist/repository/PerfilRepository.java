/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.PerfilEntity;

/**
 * Repository per a gestionar les entitats de tipus perfil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface PerfilRepository extends BaseRepository<PerfilEntity, Long> {

	@Query(	"select " +
			"    puie.perfil " +
			" from " +
			"    PerfilUsuariIdentificadorEmpresaEntity puie " +
			"where " +
			"    puie.usuariIdentificadorEmpresa.usuariIdentificador.usuari.embedded.codi = :usuariCodi " + 
			"and puie.usuariIdentificadorEmpresa.usuariIdentificador.identificador.id = :identificadorId " +
			"and puie.usuariIdentificadorEmpresa.empresa.id = :empresaId")
	List<PerfilEntity> findByUsuariCodiAndIdentificadorIdAndEmpresaId(
			@Param("usuariCodi") String usuariCodi,
			@Param("identificadorId") Long identificadorId,
			@Param("empresaId") Long empresaId);

}
