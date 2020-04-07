/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.ProveidorVenciment.ProveidorVencimentPk;
import es.limit.cecocloud.fact.persist.entity.ProveidorVencimentEntity;

/**
 * Repositori per a gestionar les entitats de ProveidorVenciment.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

public interface ProveidorVencimentRepository extends BaseRepository<ProveidorVencimentEntity, ProveidorVencimentPk> {

}
