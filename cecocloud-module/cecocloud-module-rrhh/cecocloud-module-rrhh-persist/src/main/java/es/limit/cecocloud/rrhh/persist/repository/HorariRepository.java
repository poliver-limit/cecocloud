/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableAmbIdentificador.AmbIdentificadorICodiPk;
import es.limit.cecocloud.rrhh.persist.entity.HorariEntity;

/**
 * Repositori per a gestionar les entitats de tipus Horari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface HorariRepository extends BaseRepository<HorariEntity, AmbIdentificadorICodiPk<String>> {
}