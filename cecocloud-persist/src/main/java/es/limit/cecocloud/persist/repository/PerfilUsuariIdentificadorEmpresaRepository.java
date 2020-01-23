/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.PerfilUsuariIdentificadorEmpresaEntity;
import es.limit.cecocloud.persist.entity.UsuariIdentificadorEmpresaEntity;

/**
 * Repository per a gestionar les entitats de tipus perfil-(usuari-identificador-empresa).
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface PerfilUsuariIdentificadorEmpresaRepository extends BaseRepository<PerfilUsuariIdentificadorEmpresaEntity, Long> {

	List<PerfilUsuariIdentificadorEmpresaEntity> findByUsuariIdentificadorEmpresa(UsuariIdentificadorEmpresaEntity usuariIdentificadorEmpresa);

}
