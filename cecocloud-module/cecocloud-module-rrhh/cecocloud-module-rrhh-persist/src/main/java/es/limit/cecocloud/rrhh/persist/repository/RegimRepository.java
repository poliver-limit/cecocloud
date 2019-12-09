/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.Regim.RegimPk;
import es.limit.cecocloud.rrhh.persist.entity.RegimEntity;

/**
 * Repositori per a gestionar les entitats de tipus Regim.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface RegimRepository extends BaseRepository<RegimEntity, RegimPk> {
}