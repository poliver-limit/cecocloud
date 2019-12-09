/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.RegistreDiari.RegistreDiariPk;
import es.limit.cecocloud.rrhh.persist.entity.RegistreDiariEntity;

/**
 * Repositori per a gestionar les entitats de tipus RegistreDiari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface RegistreDiariRepository extends BaseRepository<RegistreDiariEntity, RegistreDiariPk> {
}