/**
 * 
 */
package es.limit.cecocloud.marc.persist.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.marc.persist.entity.MarcatgeEntity;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.OperariEmpresaEntity;

/**
 * Repository per a gestionar les entitats de tipus marcatge.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface MarcatgeRepository extends BaseRepository<MarcatgeEntity, Long> {

	@Query(	"from" +
			"    MarcatgeEntity m " +
			"where " +
			"    m.embedded.origen = es.limit.cecocloud.marc.logic.api.dto.MarcatgeOrigen.MOBIL " +
			"and m.operariEmpresa.empresa in (:empreses) " +
			"and m.createdDate >= :dataInici " +
			"and (:esNullDataFi = true or m.createdDate <= :dataFi) " +
			"order by " +
			"    m.operariEmpresa.empresa.embedded.codi asc, " +
			"    m.embedded.data asc")
	List<MarcatgeEntity> findByEmpresaInAndBetweenDatesSync(
			@Param("empreses") List<EmpresaEntity> empreses,
			@Param("dataInici") Date dataInici,
			@Param("esNullDataFi") boolean esNullDataFi,
			@Param("dataFi") Date dataFi);

	@Query(	"from" +
			"    MarcatgeEntity m " +
			"where " +
			"    m.operariEmpresa = :operariEmpresa " +
			"and m.embedded.data >= :dataInici " +
			"and (:esNullDataFi = true or m.embedded.data <= :dataFi) " +
			"order by " +
			"    m.embedded.data desc")
	List<MarcatgeEntity> findByOperariEmpresaAndBetweenDatesMobile(
			@Param("operariEmpresa") OperariEmpresaEntity operariEmpresa,
			@Param("dataInici") Date dataInici,
			@Param("esNullDataFi") boolean esNullDataFi,
			@Param("dataFi") Date dataFi);

	MarcatgeEntity findFirstByOperariEmpresaOrderByEmbeddedDataDesc(OperariEmpresaEntity operariEmpresa);

	MarcatgeEntity findByOperariEmpresaAndEmbeddedData(
			OperariEmpresaEntity operariEmpresa,
			Date data);

}
