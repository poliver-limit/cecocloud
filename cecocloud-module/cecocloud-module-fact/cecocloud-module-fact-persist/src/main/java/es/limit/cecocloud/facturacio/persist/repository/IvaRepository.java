/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableAmbIdentificadorICodi.AmbIdentificadorICodiPk;
import es.limit.cecocloud.facturacio.persist.entity.IvaEntity;

/**
 * Repositori per a gestionar les entitats de tipus iva.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface IvaRepository extends BaseRepository<IvaEntity, AmbIdentificadorICodiPk<String>> {
}