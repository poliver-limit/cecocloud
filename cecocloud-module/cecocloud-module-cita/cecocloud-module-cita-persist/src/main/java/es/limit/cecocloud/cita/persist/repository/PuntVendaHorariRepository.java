/**
 * 
 */
package es.limit.cecocloud.cita.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.cita.logic.api.dto.PuntVendaHorari.PuntVendaHorariPk;
import es.limit.cecocloud.cita.persist.entity.PuntVendaHorariEntity;

/**
 * Repositori per a gestionar les entitats de tipus horari de punt de venda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface PuntVendaHorariRepository extends BaseRepository<PuntVendaHorariEntity, PuntVendaHorariPk> {
}