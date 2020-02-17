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
import es.limit.cecocloud.persist.entity.PerfilUsuariIdentificadorEmpresaEntity;
import es.limit.cecocloud.persist.entity.UsuariIdentificadorEmpresaEntity;

/**
 * Repository per a gestionar les entitats de tipus perfil-(usuari-identificador-empresa).
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface PerfilUsuariIdentificadorEmpresaRepository extends BaseRepository<PerfilUsuariIdentificadorEmpresaEntity, Long> {

	List<PerfilUsuariIdentificadorEmpresaEntity> findByUsuariIdentificadorEmpresa(UsuariIdentificadorEmpresaEntity usuariIdentificadorEmpresa);
//	List<PerfilUsuariIdentificadorEmpresaEntity> findByUsuariIdentificadorEmpresaUsuariIdentificadorUsuariIdAndUsuariIdentificadorEmpresaUsuariIdentificadorIdentificadorIdAndUsuariIdentificadorEmpresaEmpresaId(
//		Long usuariId,
//		Long identificadorId,
//		Long empresaId);

	@Query(	"select puie.perfil " +
			" from " +
			"    PerfilUsuariIdentificadorEmpresaEntity puie " +
			"    left outer join puie.usuariIdentificadorEmpresa as uie " +
			"    left outer join uie.empresa as e" +
			"    left outer join uie.usuariIdentificador as ui " +
			"    left outer join ui.usuari as u " +
//			"    left outer join ui.identificador as i " +
			"where " +
			"    e.id = :empresaId " +
			"and u.embedded.codi = :usuariCodi " +
			"and ui.identificador.id = :identificadorId")	
	List<PerfilEntity> findPerfilsByUsuariCodiAndIdentificadorIdAndEmpresaId(
			@Param("usuariCodi") String usuariCodi,
			@Param("identificadorId") Long identificadorId,
			@Param("empresaId") Long empresaId);
}
