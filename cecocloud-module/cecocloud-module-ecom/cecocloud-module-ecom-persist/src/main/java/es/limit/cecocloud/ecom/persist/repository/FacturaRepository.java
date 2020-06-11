/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.Factura.FacturaPk;
import es.limit.cecocloud.ecom.persist.entity.FacturaEntity;

/**
 * Repositori per a gestionar les entitats de tipus Factura.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomFacturaRepository")
public interface FacturaRepository extends BaseRepository<FacturaEntity, FacturaPk> {
}