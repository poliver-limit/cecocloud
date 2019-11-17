/**
 * 
 */
package es.limit.cecocloud.marcatges.persist.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.limit.base.boot.persist.entity.UsuariEntity;
import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.marcatges.persist.entity.OperariEntity;
import es.limit.cecocloud.persist.entity.CompanyiaEntity;
import es.limit.cecocloud.persist.entity.EmpresaEntity;

/**
 * Repository per a gestionar les entitats de tipus operari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface OperariRepository extends BaseRepository<OperariEntity, Long> {

	List<OperariEntity> findByEmpresaIdentificadorCompanyia(CompanyiaEntity companyia);

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

	Optional<OperariEntity> findByEmpresaIdentificadorCompanyiaAndEmpresaIdentificadorCodiAndEmpresaEmbeddedCodiAndEmbeddedCodi(
			CompanyiaEntity companyia,
			String empresaIdentificadorCodi,
			String empresaCodi,
			String codi);

	List<OperariEntity> findByUsuariAndEmpresa(UsuariEntity usuari, EmpresaEntity empresa);

	Optional<OperariEntity> findByUsuariAndEmpresaAndEmbeddedDataFiNull(UsuariEntity usuari, EmpresaEntity empresa);

}
