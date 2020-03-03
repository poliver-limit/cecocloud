/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.Producte.ProductePk;
import es.limit.cecocloud.fact.persist.entity.ProducteEntity;

/**
 * Repositori per a gestionar les entitats de Producte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

public interface ProducteRepository extends BaseRepository<ProducteEntity, ProductePk> {

}
