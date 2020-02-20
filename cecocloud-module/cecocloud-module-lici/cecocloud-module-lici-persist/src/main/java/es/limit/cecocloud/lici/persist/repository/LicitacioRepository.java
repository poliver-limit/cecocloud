/**
 * 
 */
package es.limit.cecocloud.lici.persist.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.lici.persist.entity.LicitacioEntity;
import es.limit.cecocloud.persist.entity.EmpresaEntity;

/**
 * Repository per a gestionar l'entitat de licitació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface LicitacioRepository extends BaseRepository<LicitacioEntity, Long> {

	Optional<LicitacioEntity> findByEmpresaAndEmbeddedCodi(EmpresaEntity empresa, String codi);

}
