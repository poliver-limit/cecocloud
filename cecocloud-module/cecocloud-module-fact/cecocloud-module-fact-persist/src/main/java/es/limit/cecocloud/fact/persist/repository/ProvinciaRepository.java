/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.Provincia.ProvinciaPk;
import es.limit.cecocloud.fact.persist.entity.ProvinciaEntity;

/**
 * Repositori per a gestionar les entitats de tipus provincia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface ProvinciaRepository extends BaseRepository<ProvinciaEntity, ProvinciaPk> {
}