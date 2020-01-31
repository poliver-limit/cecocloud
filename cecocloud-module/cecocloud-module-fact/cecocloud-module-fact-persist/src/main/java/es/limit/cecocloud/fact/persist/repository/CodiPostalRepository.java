/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.CodiPostalEntity;

/**
 * Repositori per a gestionar les entitats de tipus codi postal.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface CodiPostalRepository extends BaseRepository<CodiPostalEntity, WithIdentificadorAndCodiPk<String>> {
}