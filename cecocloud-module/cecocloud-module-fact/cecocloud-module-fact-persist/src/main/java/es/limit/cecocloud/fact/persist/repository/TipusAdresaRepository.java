/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.TipusAdresaEntity;

/**
 * Repositori per a gestionar les entitats de TipusAdresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface TipusAdresaRepository extends BaseRepository<TipusAdresaEntity, WithIdentificadorAndCodiPk<String>> {
}
