/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.Stock.StockPk;
import es.limit.cecocloud.ecom.persist.entity.StockEntity;

/**
 * Repositori per a gestionar les entitats de tipus Stock.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomStockRepository")
public interface StockRepository extends BaseRepository<StockEntity, StockPk> {
}