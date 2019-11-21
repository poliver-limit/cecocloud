/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.NaturalesaPagamentCobrament.NaturalesaPagamentCobramentPk;
import es.limit.cecocloud.facturacio.persist.entity.NaturalesaPagamentCobramentEntity;

/**
 * Repositori per a gestionar les entitats de tipus nNaturalesa de pagament/cobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface NaturalesaPagamentCobramentRepository extends BaseRepository<NaturalesaPagamentCobramentEntity, NaturalesaPagamentCobramentPk> {
}