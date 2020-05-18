/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.SerieCompra.SerieCompraPk;
import es.limit.cecocloud.ecom.persist.entity.SerieCompraEntity;

/**
 * Repositori per a gestionar les entitats de tipus SerieCompra.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomSerieCompraRepository")
public interface SerieCompraRepository extends BaseRepository<SerieCompraEntity, SerieCompraPk> {
}