/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.SeccioGrup.SeccioGrupPk;
import es.limit.cecocloud.facturacio.persist.entity.SeccioGrupEntity;

/**
 * Repositori per a gestionar les entitats de tipus SeccioGrup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface SeccioGrupRepository extends BaseRepository<SeccioGrupEntity, SeccioGrupPk> {
}