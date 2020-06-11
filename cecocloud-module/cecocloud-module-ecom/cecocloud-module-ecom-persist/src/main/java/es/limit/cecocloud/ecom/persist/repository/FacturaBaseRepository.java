/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.FacturaBase.FacturaBasePk;
import es.limit.cecocloud.ecom.persist.entity.FacturaBaseEntity;

/**
 * Repositori per a gestionar les entitats de tipus FacturaBase.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomFacturaBaseRepository")
public interface FacturaBaseRepository extends BaseRepository<FacturaBaseEntity, FacturaBasePk> {
}