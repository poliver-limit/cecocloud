/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.logic.api.dto.PerfilRol.PerfilRolPk;
import es.limit.cecocloud.persist.entity.PerfilRolEntity;

/**
 * Repository per a gestionar les entitats de tipus perfil-rol.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface PerfilRolRepository extends BaseRepository<PerfilRolEntity, PerfilRolPk> {
}
