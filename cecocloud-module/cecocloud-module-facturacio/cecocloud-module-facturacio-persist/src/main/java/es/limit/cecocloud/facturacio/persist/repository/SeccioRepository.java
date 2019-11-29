/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.Seccio.SeccioPk;
import es.limit.cecocloud.facturacio.persist.entity.SeccioEntity;

/**
 * Repositori per a gestionar les entitats de tipus Seccio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface SeccioRepository extends BaseRepository<SeccioEntity, SeccioPk> {
}