/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.Pais.PaisPk;
import es.limit.cecocloud.facturacio.persist.entity.PaisEntity;

/**
 * Repositori per a gestionar les entitats de tipus pais.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface PaisRepository extends BaseRepository<PaisEntity, PaisPk> {
}