/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.TipusDia.TipusDiaPk;
import es.limit.cecocloud.rrhh.persist.entity.TipusDiaEntity;

/**
 * Repositori per a gestionar les entitats de tipus TipusDia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface TipusDiaRepository extends BaseRepository<TipusDiaEntity, TipusDiaPk> {
}