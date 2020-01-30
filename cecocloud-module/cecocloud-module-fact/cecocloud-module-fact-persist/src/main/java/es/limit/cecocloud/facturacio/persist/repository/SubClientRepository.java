/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.SubClient.SubClientPk;
import es.limit.cecocloud.facturacio.persist.entity.SubClientEntity;

/**
 * Repositori per a gestionar les entitats de SubClient.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

public interface SubClientRepository extends BaseRepository<SubClientEntity, SubClientPk> {

}