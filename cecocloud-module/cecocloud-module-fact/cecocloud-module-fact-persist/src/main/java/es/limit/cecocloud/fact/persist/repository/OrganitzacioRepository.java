/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.OrganitzacioEntity;

/**
 * Repositori per a gestionar les entitats de tipus organitzacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface OrganitzacioRepository extends BaseRepository<OrganitzacioEntity, WithIdentificadorAndCodiPk<String>> {
}
