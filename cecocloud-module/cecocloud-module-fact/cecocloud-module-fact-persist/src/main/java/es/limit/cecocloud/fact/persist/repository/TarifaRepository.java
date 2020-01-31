/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.TarifaEntity;

/**
 * Repositori per a gestionar les entitats de tipus Tarifa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface TarifaRepository extends BaseRepository<TarifaEntity, WithIdentificadorAndCodiPk<String>> {
}