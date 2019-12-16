/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableAmbIdentificadorICodi.AmbIdentificadorICodiPk;
import es.limit.cecocloud.facturacio.persist.entity.TarifaEntity;

/**
 * Repositori per a gestionar les entitats de tipus Tarifa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface TarifaRepository extends BaseRepository<TarifaEntity, AmbIdentificadorICodiPk<String>> {
}