/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.Departament.DepartamentPk;
import es.limit.cecocloud.facturacio.persist.entity.DepartamentEntity;

/**
 * Repositori per a gestionar les entitats de tipus Departament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface DepartamentRepository extends BaseRepository<DepartamentEntity, DepartamentPk> {
}