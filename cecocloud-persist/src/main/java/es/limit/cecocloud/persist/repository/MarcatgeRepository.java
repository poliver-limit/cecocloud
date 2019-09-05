/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.MarcatgeEntity;
import es.limit.cecocloud.persist.entity.OperariEntity;

/**
 * Repository per a gestionar les entitats de tipus marcatge.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface MarcatgeRepository extends BaseRepository<MarcatgeEntity, Long> {

	@Query(	"from" +
			"    MarcatgeEntity m " +
			"where " +
			"    m.operari.empresa in (:empreses) " +
			"and m.embedded.data >= :dataInici " +
			"and (:esNullDataFi = true or m.embedded.data <= :dataFi) " +
			"order by " +
			"    m.operari.empresa.embedded.identificadorCodi asc, " +
			"    m.operari.empresa.embedded.codi asc, " +
			"    m.embedded.data asc")
	List<MarcatgeEntity> findByEmpresaInAndBetweenDatesMobile(
			@Param("empreses") List<EmpresaEntity> empreses,
			@Param("dataInici") Date dataInici,
			@Param("esNullDataFi") boolean esNullDataFi,
			@Param("dataFi") Date dataFi);

	@Query(	"from" +
			"    MarcatgeEntity m " +
			"where " +
			"    m.operari.empresa in (:empreses) " +
			"and m.createdDate >= :dataInici " +
			"and (:esNullDataFi = true or m.createdDate <= :dataFi) " +
			"order by " +
			"    m.operari.empresa.embedded.identificadorCodi asc, " +
			"    m.operari.empresa.embedded.codi asc, " +
			"    m.embedded.data asc")
	List<MarcatgeEntity> findByEmpresaInAndBetweenDatesSync(
			@Param("empreses") List<EmpresaEntity> empreses,
			@Param("dataInici") Date dataInici,
			@Param("esNullDataFi") boolean esNullDataFi,
			@Param("dataFi") Date dataFi);

	MarcatgeEntity findFirstByOperariOrderByEmbeddedDataDesc(OperariEntity operari);

	MarcatgeEntity findByOperariAndEmbeddedData(
			OperariEntity operari,
			Date data);

}
