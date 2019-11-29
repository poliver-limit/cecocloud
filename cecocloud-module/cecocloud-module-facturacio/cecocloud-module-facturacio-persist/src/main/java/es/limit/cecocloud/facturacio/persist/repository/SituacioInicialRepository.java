/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.SituacioInicial.SituacioInicialPk;
import es.limit.cecocloud.facturacio.persist.entity.SituacioInicialEntity;

/**
 * Repositori per a gestionar les entitats de tipus SituacioInicial.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface SituacioInicialRepository extends BaseRepository<SituacioInicialEntity, SituacioInicialPk> {
}