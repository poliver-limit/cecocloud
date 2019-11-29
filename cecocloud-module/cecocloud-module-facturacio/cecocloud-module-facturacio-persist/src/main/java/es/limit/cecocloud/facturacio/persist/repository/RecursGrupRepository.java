/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.RecursGrup.RecursGrupPk;
import es.limit.cecocloud.facturacio.persist.entity.RecursGrupEntity;

/**
 * Repositori per a gestionar les entitats de tipus RecursGrup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface RecursGrupRepository extends BaseRepository<RecursGrupEntity, RecursGrupPk> {
}