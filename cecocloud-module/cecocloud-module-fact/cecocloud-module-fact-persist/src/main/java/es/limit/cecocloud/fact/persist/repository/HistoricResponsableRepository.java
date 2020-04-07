/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.HistoricResponsable.HistoricResponsablePk;
import es.limit.cecocloud.fact.persist.entity.HistoricResponsableEntity;

/**
 * Repositori per a gestionar les entitats de tipus HistoricResponsable.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface HistoricResponsableRepository extends BaseRepository<HistoricResponsableEntity, HistoricResponsablePk> {
}