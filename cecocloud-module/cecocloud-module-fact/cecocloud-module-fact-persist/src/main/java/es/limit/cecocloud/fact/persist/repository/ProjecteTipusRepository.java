/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.ProjecteTipusEntity;

/**
 * Repositori per a gestionar les entitats de tipus ProjecteTipus.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface ProjecteTipusRepository extends BaseRepository<ProjecteTipusEntity, WithIdentificadorAndCodiPk<String>> {
}
