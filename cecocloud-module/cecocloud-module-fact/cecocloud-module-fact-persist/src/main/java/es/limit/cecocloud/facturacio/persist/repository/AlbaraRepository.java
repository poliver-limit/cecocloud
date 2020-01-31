/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.Albara.AlbaraPk;
import es.limit.cecocloud.facturacio.persist.entity.AlbaraEntity;

/**
 * Repositori per a gestionar les entitats de tipus Albara.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface AlbaraRepository extends BaseRepository<AlbaraEntity, AlbaraPk> {
}