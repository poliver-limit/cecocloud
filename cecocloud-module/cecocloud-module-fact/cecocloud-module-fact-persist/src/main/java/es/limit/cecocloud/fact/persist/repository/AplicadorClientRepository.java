/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.AplicadorClient.AplicadorClientPk;
import es.limit.cecocloud.fact.persist.entity.AplicadorClientEntity;

/**
 * Repositori per a gestionar les entitats de tipus aplicador-client.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface AplicadorClientRepository extends BaseRepository<AplicadorClientEntity, AplicadorClientPk> {
}