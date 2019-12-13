/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.logic.api.dto.RolUsuariIdentificadorEmpresa.RolUsuariIdentificadorEmpresaPk;
import es.limit.cecocloud.persist.entity.RolUsuariIdentificadorEmpresaEntity;

/**
 * Repository per a gestionar les entitats de tipus rol-(usuari-identificador-empresa).
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface RolUsuariIdentificadorEmpresaRepository extends BaseRepository<RolUsuariIdentificadorEmpresaEntity, RolUsuariIdentificadorEmpresaPk> {

}
