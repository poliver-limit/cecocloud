/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.TipusClient.TipusClientPk;
import es.limit.cecocloud.fact.persist.entity.TipusClientEntity;

/**
 * Repositori per a gestionar les entitats de tipus tipus-client.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface TipusClientRepository extends BaseRepository<TipusClientEntity, TipusClientPk> {
}