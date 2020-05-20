/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.PressupostLinia.PressupostLiniaPk;
import es.limit.cecocloud.ecom.persist.entity.PressupostLiniaEntity;

/**
 * Repositori per a gestionar les entitats de tipus PressupostLinia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomPressupostLiniaRepository")
public interface PressupostLiniaRepository extends BaseRepository<PressupostLiniaEntity, PressupostLiniaPk> {
}