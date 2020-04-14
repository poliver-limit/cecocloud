/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.TarifaProveidor.TarifaProveidorPk;
import es.limit.cecocloud.fact.persist.entity.TarifaProveidorEntity;

/**
 * Repositori per a gestionar les entitats de tipus TarifaProveidor.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface TarifaProveidorRepository extends BaseRepository<TarifaProveidorEntity, TarifaProveidorPk> {
}