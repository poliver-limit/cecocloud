/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.Aplicador.AplicadorPk;
import es.limit.cecocloud.fact.persist.entity.AplicadorEntity;

/**
 * Repositori per a gestionar les entitats de Aplicador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

public interface AplicadorRepository extends BaseRepository<AplicadorEntity, AplicadorPk> {

}
