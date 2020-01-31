/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.SubClient.SubClientPk;
import es.limit.cecocloud.fact.persist.entity.SubClientEntity;

/**
 * Repositori per a gestionar les entitats de SubClient.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

public interface SubClientRepository extends BaseRepository<SubClientEntity, SubClientPk> {

}