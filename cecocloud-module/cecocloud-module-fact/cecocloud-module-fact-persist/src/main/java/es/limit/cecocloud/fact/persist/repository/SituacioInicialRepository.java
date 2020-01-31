/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.SituacioInicial.SituacioInicialPk;
import es.limit.cecocloud.fact.persist.entity.SituacioInicialEntity;

/**
 * Repositori per a gestionar les entitats de tipus SituacioInicial.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface SituacioInicialRepository extends BaseRepository<SituacioInicialEntity, SituacioInicialPk> {
}