/**
 * 
 */
package es.limit.cecocloud.cita.persist.repository;

import java.util.List;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.cita.logic.api.dto.HorariInterval.HorariIntervalPk;
import es.limit.cecocloud.cita.persist.entity.HorariEntity;
import es.limit.cecocloud.cita.persist.entity.HorariIntervalEntity;

/**
 * Repositori per a gestionar les entitats de tipus interval horari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface HorariIntervalRepository extends BaseRepository<HorariIntervalEntity, HorariIntervalPk> {

	List<HorariIntervalEntity> findByHorari(HorariEntity horari);

}