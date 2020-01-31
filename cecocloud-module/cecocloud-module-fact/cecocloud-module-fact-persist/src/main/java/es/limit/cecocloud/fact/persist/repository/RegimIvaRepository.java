/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.RegimIvaEntity;

/**
 * Repositori per a gestionar les entitats de tipus regim d'Iva.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface RegimIvaRepository extends BaseRepository<RegimIvaEntity, WithIdentificadorAndCodiPk<String>> {
}