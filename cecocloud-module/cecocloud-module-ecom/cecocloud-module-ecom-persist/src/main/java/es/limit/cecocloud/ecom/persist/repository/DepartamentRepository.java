/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.Departament.DepartamentPk;
import es.limit.cecocloud.ecom.persist.entity.DepartamentEntity;

/**
 * Repositori per a gestionar les entitats de tipus Departament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomDepartamentRepository")
public interface DepartamentRepository extends BaseRepository<DepartamentEntity, DepartamentPk> {
}