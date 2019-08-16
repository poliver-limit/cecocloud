/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.OperariEntity;
import es.limit.cecocloud.persist.entity.UsuariEntity;
/**
 * Repository per a gestionar les entitats de tipus operari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface OperariRepository extends BaseRepository<OperariEntity, Long> {

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

	List<OperariEntity> findByUsuariAndEmpresa(UsuariEntity usuari, EmpresaEntity empresa);

}
