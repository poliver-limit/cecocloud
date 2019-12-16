/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.PerfilEntity;

/**
 * Repository per a gestionar les entitats de tipus perfil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface PerfilRepository extends BaseRepository<PerfilEntity, Long> {
}
