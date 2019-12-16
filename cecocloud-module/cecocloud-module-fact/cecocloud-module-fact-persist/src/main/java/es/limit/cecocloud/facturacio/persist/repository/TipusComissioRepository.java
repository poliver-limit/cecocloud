/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableAmbIdentificadorICodi.AmbIdentificadorICodiPk;
import es.limit.cecocloud.facturacio.persist.entity.TipusComissioEntity;

/**
 * Repositori per a gestionar les entitats de tipus TipusComissio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface TipusComissioRepository extends BaseRepository<TipusComissioEntity, AmbIdentificadorICodiPk<String>> {
}