/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.facturacio.persist.entity.RegimIvaEntity;

/**
 * Repositori per a gestionar les entitats de tipus regim d'Iva.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface RegimIvaRepository extends BaseRepository<RegimIvaEntity, WithIdentificadorAndCodiPk<String>> {
}