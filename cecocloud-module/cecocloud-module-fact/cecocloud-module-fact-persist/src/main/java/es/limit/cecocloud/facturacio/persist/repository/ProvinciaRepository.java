/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.Provincia.ProvinciaPk;
import es.limit.cecocloud.facturacio.persist.entity.ProvinciaEntity;

/**
 * Repositori per a gestionar les entitats de tipus provincia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface ProvinciaRepository extends BaseRepository<ProvinciaEntity, ProvinciaPk> {
}