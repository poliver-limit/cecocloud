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

	/*@Query(	"from" +
			"    OperariEntity op " +
			"where " +
			"    op.usuari = :usuari " +
			"and op.embedded.dataInici <= :dataInicial " +
			"and op.embedded.dataFi is null " +
			"and op.empresa.embedded.activa = :activa")
	List<OperariEntity> findByUsuariAndDataFiNullAndEmpresaActiva(
			@Param("usuari") UsuariEntity usuari,
			@Param("dataInicial") Date dataInicial,
			@Param("activa") boolean activa);

	@Query(	"from" +
			"    OperariEntity op " +
			"where " +
			"    op.empresa = :empresa " +
			"and op.embedded.dataFi is null")
	List<OperariEntity> findByEmpresaAndDataFiNull(
			@Param("empresa") EmpresaEntity empresa);

	Optional<OperariEntity> findByEmpresaIdentificadorAndEmpresaEmbeddedCodiAndEmbeddedCodi(
			IdentificadorEntity identificador,
			String empresaCodi,
			String codi);

	List<OperariEntity> findByUsuariAndEmpresa(UsuariEntity usuari, EmpresaEntity empresa);

	Optional<OperariEntity> findByUsuariAndEmpresaAndEmbeddedDataFiNull(UsuariEntity usuari, EmpresaEntity empresa);*/

}
