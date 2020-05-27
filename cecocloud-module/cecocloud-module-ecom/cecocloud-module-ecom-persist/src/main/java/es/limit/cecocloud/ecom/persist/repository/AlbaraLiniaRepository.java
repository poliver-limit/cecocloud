/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.AlbaraLinia.AlbaraLiniaPk;
import es.limit.cecocloud.ecom.persist.entity.AlbaraLiniaEntity;

/**
 * Repositori per a gestionar les entitats de tipus AlbaraLinia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomAlbaraLiniaRepository")
public interface AlbaraLiniaRepository extends BaseRepository<AlbaraLiniaEntity, AlbaraLiniaPk> {
}