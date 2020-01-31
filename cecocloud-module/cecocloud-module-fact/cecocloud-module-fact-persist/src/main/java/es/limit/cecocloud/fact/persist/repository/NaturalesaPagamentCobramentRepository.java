/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.NaturalesaPagamentCobramentEntity;

/**
 * Repositori per a gestionar les entitats de tipus nNaturalesa de pagament/cobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface NaturalesaPagamentCobramentRepository extends BaseRepository<NaturalesaPagamentCobramentEntity, WithIdentificadorAndCodiPk<String>> {
}