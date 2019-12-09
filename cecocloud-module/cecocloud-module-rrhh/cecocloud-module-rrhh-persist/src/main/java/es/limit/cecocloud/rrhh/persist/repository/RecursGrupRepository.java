/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.RecursGrup.RecursGrupPk;
import es.limit.cecocloud.rrhh.persist.entity.RecursGrupEntity;

/**
 * Repositori per a gestionar les entitats de tipus RecursGrup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface RecursGrupRepository extends BaseRepository<RecursGrupEntity, RecursGrupPk> {
}