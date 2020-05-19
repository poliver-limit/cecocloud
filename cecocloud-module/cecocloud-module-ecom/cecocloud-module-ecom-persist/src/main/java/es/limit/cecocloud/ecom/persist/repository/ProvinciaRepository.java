/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.Provincia.ProvinciaPk;
import es.limit.cecocloud.ecom.persist.entity.ProvinciaEntity;

/**
 * Repositori per a gestionar les entitats de tipus Provincia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomProvinciaRepository")
public interface ProvinciaRepository extends BaseRepository<ProvinciaEntity, ProvinciaPk> {
}