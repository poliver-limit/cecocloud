/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.Magatzem.MagatzemPk;
import es.limit.cecocloud.facturacio.persist.entity.MagatzemEntity;

/**
 * Repositori per a gestionar les entitats de tipus Magatzem.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface MagatzemRepository extends BaseRepository<MagatzemEntity, MagatzemPk> {
}