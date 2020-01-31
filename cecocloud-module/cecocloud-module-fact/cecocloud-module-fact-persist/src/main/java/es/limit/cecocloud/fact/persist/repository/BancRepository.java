/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.BancEntity;

/**
 * Repositori per a gestionar les entitats de tipus Banc.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface BancRepository extends BaseRepository<BancEntity, WithIdentificadorAndCodiPk<Integer>> {
}