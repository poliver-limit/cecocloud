/**
 * 
 */
package es.limit.cecocloud.marc.persist.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.entity.UsuariEntity;
import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.marc.persist.entity.OperariEntity;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;

/**
 * Repository per a gestionar les entitats de tipus operari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("OperariMarcRepository")
public interface OperariRepository extends BaseRepository<OperariEntity, Long> {

	List<OperariEntity> findByEmpresaIdentificador(IdentificadorEntity identificador);

	@Query(	"from" +
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

	Optional<OperariEntity> findByUsuariAndEmpresaAndEmbeddedDataFiNull(UsuariEntity usuari, EmpresaEntity empresa);

}
