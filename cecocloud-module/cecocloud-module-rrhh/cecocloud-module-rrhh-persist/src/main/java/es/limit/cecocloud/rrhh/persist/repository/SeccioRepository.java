/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.Seccio.SeccioPk;
import es.limit.cecocloud.rrhh.persist.entity.SeccioEntity;

/**
 * Repositori per a gestionar les entitats de tipus Article.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface SeccioRepository extends BaseRepository<SeccioEntity, SeccioPk> {
}