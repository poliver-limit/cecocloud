/**
 * 
 */
package es.limit.cecocloud.cita.persist.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.cita.logic.api.dto.Cita.CitaPk;
import es.limit.cecocloud.cita.persist.entity.CitaEntity;
import es.limit.cecocloud.fact.persist.entity.PuntVendaEntity;

/**
 * Repositori per a gestionar les entitats de tipus cita.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface CitaRepository extends BaseRepository<CitaEntity, CitaPk> {

	@Query(
			"from CitaEntity cit " +
			"where " +
			"    cit.puntVenda = :puntVenda " +
			"and cit.embedded.data between :dataInici and :dataFi " +
			"and cit.embedded.anulacioData is null")
	List<CitaEntity> findByPuntVendaAndEmbeddedDataBetweenAndAnulacioDataNullSortByEmbeddedData(
			@Param("puntVenda") PuntVendaEntity puntVenda,
			@Param("dataInici") LocalDateTime dataInici,
			@Param("dataFi") LocalDateTime dataFi);

}