/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.Albara.AlbaraPk;
import es.limit.cecocloud.ecom.persist.entity.AlbaraEntity;

/**
 * Repositori per a gestionar les entitats de tipus Albara.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomAlbaraRepository")
public interface AlbaraRepository extends BaseRepository<AlbaraEntity, AlbaraPk> {
}