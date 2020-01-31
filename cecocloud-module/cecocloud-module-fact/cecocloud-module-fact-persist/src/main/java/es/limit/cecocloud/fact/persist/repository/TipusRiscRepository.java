/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.TipusRiscEntity;

/**
 * Repositori per a gestionar les entitats de tipus TipusRisc.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface TipusRiscRepository extends BaseRepository<TipusRiscEntity, WithIdentificadorAndCodiPk<String>> {
}