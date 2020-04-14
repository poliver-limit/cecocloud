/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.Partida.PartidaPk;
import es.limit.cecocloud.fact.persist.entity.PartidaEntity;

/**
 * Repositori per a gestionar les entitats de tipus Partida.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface PartidaRepository extends BaseRepository<PartidaEntity, PartidaPk> {
}