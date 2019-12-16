/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableAmbIdentificadorICodi.AmbIdentificadorICodiPk;
import es.limit.cecocloud.facturacio.persist.entity.DivisaEntity;

/**
 * Repositori per a gestionar les entitats de tipus divisa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface DivisaRepository extends BaseRepository<DivisaEntity, AmbIdentificadorICodiPk<String>> {
}