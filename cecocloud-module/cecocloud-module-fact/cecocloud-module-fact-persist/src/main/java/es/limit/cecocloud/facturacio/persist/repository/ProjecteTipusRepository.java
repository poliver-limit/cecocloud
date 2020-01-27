/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.facturacio.persist.entity.ProjecteTipusEntity;

/**
 * Repositori per a gestionar les entitats de tipus ProjecteTipus.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface ProjecteTipusRepository extends BaseRepository<ProjecteTipusEntity, WithIdentificadorAndCodiPk<String>> {
}
