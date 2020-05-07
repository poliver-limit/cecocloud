/**
 * 
 */
package es.limit.cecocloud.cita.persist.repository;

import java.time.LocalDateTime;
import java.util.List;

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

	List<CitaEntity> findByPuntVendaAndEmbeddedDataBetweenSortByEmbeddedData(
			PuntVendaEntity puntVenda,
			LocalDateTime dataInici,
			LocalDateTime dataFi);

}