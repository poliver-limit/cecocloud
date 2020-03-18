/*
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.Provincia.ProvinciaPk;
import es.limit.cecocloud.rrhh.persist.entity.ProvinciaEntity;

/**
 * Repositori per a gestionar les entitats de tipus provincia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

@Repository("rrhhProvinciaRepository")
public interface ProvinciaRepository extends BaseRepository<ProvinciaEntity, ProvinciaPk> {
}
