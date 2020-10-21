/**
 * 
 */
package es.limit.cecocloud.marc.persist.repository;

import java.math.BigDecimal;
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
			"    (m.embedded.origen = es.limit.cecocloud.marc.logic.api.dto.MarcatgeOrigen.MOBIL or m.embedded.origen = es.limit.cecocloud.marc.logic.api.dto.MarcatgeOrigen.CECOCLOUD) " +
			"and m.operariEmpresa.empresa in (:empreses) " +
			"and (:esNullDataInici = true or m.createdDate >= :dataInici) " +
			"and (:esNullDataFi = true or m.createdDate <= :dataFi) " +
			"and (:esNullValidatDataInici = true or m.embedded.validatData >= :validatDataInici) " +
			"and (:esNullValidatDataFi = true or m.embedded.validatData <= :validatDataFi) " +
			"and (:esNullIdInici = true or m.id >= :idInici) " +
			"and (:esNullIdFi = true or m.id <= :idFi) " +
			"and (:esNullValidat = true or m.embedded.validat = :validat) " +
			"order by " +
			"    m.operariEmpresa.empresa.embedded.codi asc, " +
			"    m.id asc")
	List<MarcatgeEntity> findByEmpresaInAndBetweenDatesSync(
			@Param("empreses") List<EmpresaEntity> empreses,
			@Param("esNullDataInici") boolean esNullDataInici,
			@Param("dataInici") Date dataInici,
			@Param("esNullDataFi") boolean esNullDataFi,
			@Param("dataFi") Date dataFi,
			@Param("esNullValidatDataInici") boolean esNullValidatDataInici,
			@Param("validatDataInici") Date validatDataInici,
			@Param("esNullValidatDataFi") boolean esNullValidatDataFi,
			@Param("validatDataFi") Date validatDataFi,
			@Param("esNullIdInici") boolean esNullIdInici,
			@Param("idInici") Long idInici,
			@Param("esNullIdFi") boolean esNullIdFi,
			@Param("idFi") Long idFi,
			@Param("esNullValidat") boolean esNullvalidat,
			@Param("validat") Boolean validat);

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

	/*@Query(	"from" +
			"    MarcatgeEntity m " +
			"where " +
			"    m.operariEmpresa = :operariEmpresa " +
			"and m.embedded.data >= :dataInici " +
			"and m.embedded.data < :dataCalculada " +
			"and m.embedded.validat = true " +
			"order by " +
			"    m.embedded.data desc")*/
	MarcatgeEntity findFirstByOperariEmpresaAndEmbeddedDataGreaterThanEqualAndEmbeddedDataLessThanAndEmbeddedValidatTrueOrderByEmbeddedDataDesc(
			@Param("operariEmpresa") OperariEmpresaEntity operariEmpresa,
			@Param("dataInici") Date dataInici,
			@Param("dataCalculada") Date dataCalculada);

	@Query(	"from" +
			"    MarcatgeEntity m " +
			"where " +
			"    m.operariEmpresa = :operariEmpresa " +
			"and m.embedded.data >= :dataInici " +
			"and m.embedded.data <= :dataFi " +
			"and m.embedded.validat = true " +
			"and (:esNullId = true or m.id <> :id) " +
			"order by " +
			"    m.embedded.data asc")
	List<MarcatgeEntity> findByOperariEmpresaAndBetweenDatesExcludingIdOrderByEmbeddedDataAsc(
			@Param("operariEmpresa") OperariEmpresaEntity operariEmpresa,
			@Param("dataInici") Date dataInici,
			@Param("dataFi") Date dataFi,
			@Param("esNullId") boolean esNullId,
			@Param("id") Long id);

	/*@Modifying
	@Query(
			"update " +
			"    MarcatgeEntity m " +
			"set " +
			"    m.embedded.acumulatAny = null, " +
			"    m.embedded.acumulatMes = null, " +
			"    m.embedded.acumulatDia = null " +
			"where " +
			"    m.operariEmpresa = :operariEmpresa " +
			"and m.embedded.data >= :dataInici " +
			"and m.embedded.data <= :dataFi")
	void netejarAcumulatsEntreDates(
			@Param("operariEmpresa") OperariEmpresaEntity operariEmpresa,
			@Param("dataInici") Date dataInici,
			@Param("dataFi") Date dataFi);*/

	MarcatgeEntity findFirstByOperariEmpresaAndEmbeddedDataBetweenAndEmbeddedValidatTrueOrderByEmbeddedDataDesc(
			OperariEmpresaEntity operariEmpresa,
			@Param("dataInici") Date dataInici,
			@Param("dataFi") Date dataFi);

	@Query(
			"select " +
			"    sum(m.embedded.intervalDuracio) " +
			"from " +
			"    MarcatgeEntity m " +
			"where " +
			"    m.operariEmpresa = :operariEmpresa " +
			"and m.embedded.data >= :dataInici " +
			"and m.embedded.data <= :dataFi")
	BigDecimal acumulatEntreDates(
			OperariEmpresaEntity operariEmpresa,
			@Param("dataInici") Date dataInici,
			@Param("dataFi") Date dataFi);

}
