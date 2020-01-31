/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.SerieCompra.SerieCompraPk;
import es.limit.cecocloud.fact.persist.entity.SerieCompraEntity;

/**
 * Repositori per a gestionar les entitats de tipus SerieCompra.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface SerieCompraRepository extends BaseRepository<SerieCompraEntity, SerieCompraPk> {
}