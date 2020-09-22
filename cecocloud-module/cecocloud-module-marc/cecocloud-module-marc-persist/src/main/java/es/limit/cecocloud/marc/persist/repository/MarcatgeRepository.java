/**
 * 
 */
package es.limit.cecocloud.marc.persist.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
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
			"and (:esNullIdInici = true or m.id >= :idInici) " +
			"and (:esNullIdFi = true or m.id <= :idFi) " +
			"order by " +
			"    m.operariEmpresa.empresa.embedded.codi asc, " +
			"    m.id asc")
	List<MarcatgeEntity> findByEmpresaInAndBetweenDatesSync(
			@Param("empreses") List<EmpresaEntity> empreses,
			@Param("esNullDataInici") boolean esNullDataInici,
			@Param("dataInici") Date dataInici,
			@Param("esNullDataFi") boolean esNullDataFi,
			@Param("dataFi") Date dataFi,
			@Param("esNullIdInici") boolean esNullIdInici,
			@Param("idInici") Long idInici,
			@Param("esNullIdFi") boolean esNullIdFi,
			@Param("idFi") Long idFi);

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

	MarcatgeEntity findFirstByOperariEmpresaAndEmbeddedDataLessThanOrderByEmbeddedDataDesc(
			OperariEmpresaEntity operariEmpresa,
			Date data);

	List<MarcatgeEntity> findByOperariEmpresaAndEmbeddedDataGreaterThanEqualAndIdNotOrderByEmbeddedDataAsc(
			OperariEmpresaEntity operariEmpresa,
			Date data,
			Long id);

	@Modifying
	@Query(
			"update " +
			"    Marcatge m" +
			"set " +
			"    m.acumulatAny = null, " +
			"    m.acumulatMes = null, " +
			"    m.acumulatDia = null " +
			"where " +
			"    m.operariEmpresa = :operariEmpresa " +
			"and m.embedded.data >= :dataInici " +
			"and m.embedded.data <= :dataFi")
	void netejarAcumulatsEntreDates(
			@Param("operariEmpresa") OperariEmpresaEntity operariEmpresa,
			@Param("dataInici") Date dataInici,
			@Param("dataFi") Date dataFi);

	MarcatgeEntity findFirstByOperariEmpresaAndEmbeddedDataBetweenOrderByEmbeddedDataDesc(
			OperariEmpresaEntity operariEmpresa,
			@Param("dataInici") Date dataInici,
			@Param("dataFi") Date dataFi);

	@Query(
			"select " +
			"    sum(m.intervalDuracio) " +
			"from " +
			"    Marcatge m" +
			"where " +
			"    m.operariEmpresa = :operariEmpresa " +
			"and m.embedded.data >= :dataInici " +
			"and m.embedded.data <= :dataFi")
	BigDecimal acumulatEntreDates(
			OperariEmpresaEntity operariEmpresa,
			@Param("dataInici") Date dataInici,
			@Param("dataFi") Date dataFi);

}
