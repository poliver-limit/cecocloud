/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.RolUsuariEmpresaEntity;

/**
 * Mètodes necessaris per a gestionar una entitat de base
 * de dades de tipus grup-usuariEmpresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface RolUsuariEmpresaRepository extends BaseRepository<RolUsuariEmpresaEntity, Long> {
}
