/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.ClasseRetencioEntity;

/**
 * Repositori per a gestionar les entitats de tipus ClasseRetencio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface ClasseRetencioRepository extends BaseRepository<ClasseRetencioEntity, WithIdentificadorAndCodiPk<String>> {
}
