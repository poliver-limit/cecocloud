/**
 * 
 */
package es.limit.cecocloud.cita.persist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.cita.persist.entity.HorariEntity;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.PuntVendaEntity;

/**
 * Repositori per a gestionar les entitats de tipus horari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("citaHorariRepository")
public interface HorariRepository extends BaseRepository<HorariEntity, WithIdentificadorAndCodiPk<String>> {

	@Query("select pvh.puntVenda from PuntVendaHorariEntity pvh where pvh.puntVenda = :puntVenda")
	List<HorariEntity> findByPuntVenda(PuntVendaEntity puntVenda);

}