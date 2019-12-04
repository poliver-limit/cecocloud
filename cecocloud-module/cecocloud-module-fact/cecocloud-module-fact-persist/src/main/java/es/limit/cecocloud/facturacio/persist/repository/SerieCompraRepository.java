/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.SerieCompra.SerieCompraPk;
import es.limit.cecocloud.facturacio.persist.entity.SerieCompraEntity;

/**
 * Repositori per a gestionar les entitats de tipus SerieCompra.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface SerieCompraRepository extends BaseRepository<SerieCompraEntity, SerieCompraPk> {
}