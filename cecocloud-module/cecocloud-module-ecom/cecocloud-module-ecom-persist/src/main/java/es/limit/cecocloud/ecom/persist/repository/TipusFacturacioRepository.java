/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.TipusFacturacioEntity;

/**
 * Repositori per a gestionar les entitats de tipus TipusFacturacio
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomTipusFacturacioRepository")
public interface TipusFacturacioRepository extends BaseRepository<TipusFacturacioEntity, WithIdentificadorAndCodiPk<String>> {
}