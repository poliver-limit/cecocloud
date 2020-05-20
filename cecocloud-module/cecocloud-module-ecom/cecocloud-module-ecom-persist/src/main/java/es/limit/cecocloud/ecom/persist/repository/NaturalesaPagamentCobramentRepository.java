/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.NaturalesaPagamentCobramentEntity;

/**
 * Repositori per a gestionar les entitats de tipus nNaturalesa de pagament/cobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomNaturalesaPagamentCobramentRepository")
public interface NaturalesaPagamentCobramentRepository extends BaseRepository<NaturalesaPagamentCobramentEntity, WithIdentificadorAndCodiPk<String>> {
}