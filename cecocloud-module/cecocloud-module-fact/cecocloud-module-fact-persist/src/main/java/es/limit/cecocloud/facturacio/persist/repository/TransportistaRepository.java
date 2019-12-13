/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableAmbIdentificadorICodi.AmbIdentificadorICodiPk;
import es.limit.cecocloud.facturacio.persist.entity.TransportistaEntity;

/**
 * Repositori per a gestionar les entitats de tipus transportista.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface TransportistaRepository extends BaseRepository<TransportistaEntity, AmbIdentificadorICodiPk<String>> {
}