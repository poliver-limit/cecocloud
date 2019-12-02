/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.logic.api.dto.PerfilUsuariEmpresa.PerfilUsuariEmpresaPk;
import es.limit.cecocloud.persist.entity.PerfilUsuariEmpresaEntity;
import es.limit.cecocloud.persist.entity.UsuariEmpresaEntity;

/**
 * Mètodes necessaris per a gestionar una entitat de base
 * de dades de tipus perfil - usuariEmpresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface PerfilUsuariEmpresaRepository extends BaseRepository<PerfilUsuariEmpresaEntity, PerfilUsuariEmpresaPk> {
	
	List<PerfilUsuariEmpresaEntity> findByUsuariEmpresa(UsuariEmpresaEntity usuariEmpresa);
}
