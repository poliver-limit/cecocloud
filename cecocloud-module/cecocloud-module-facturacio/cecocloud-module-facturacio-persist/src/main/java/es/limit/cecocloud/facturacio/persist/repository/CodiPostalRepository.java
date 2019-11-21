/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.CodiPostal.CodiPostalPk;
import es.limit.cecocloud.facturacio.persist.entity.CodiPostalEntity;

/**
 * Repositori per a gestionar les entitats de tipus codi postal.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface CodiPostalRepository extends BaseRepository<CodiPostalEntity, CodiPostalPk> {
}