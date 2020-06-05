/**
 * 
 */
package es.limit.cecocloud.ecom.back.ecommerce.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.back.ecommerce.persist.entity.PuntVendaEcomEntity;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;

/**
 * Repositori per a gestionar les entitats de tipus PuntVenda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomBackPuntVendaRepository")
public interface PuntVendaEomRepository extends BaseRepository<PuntVendaEcomEntity, WithIdentificadorAndCodiPk<String>> {
}