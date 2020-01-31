/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.DivisaEntity;

/**
 * Repositori per a gestionar les entitats de tipus divisa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface DivisaRepository extends BaseRepository<DivisaEntity, WithIdentificadorAndCodiPk<String>> {
}