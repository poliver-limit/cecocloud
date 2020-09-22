/**
 * 
 */
package es.limit.cecocloud.marc.persist.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.marc.persist.entity.ConfiguracioEntity;
import es.limit.cecocloud.persist.entity.EmpresaEntity;

/**
 * Repository per a gestionar l'entitat de configuració.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("marcConfiguracioRepository")
public interface ConfiguracioRepository extends BaseRepository<ConfiguracioEntity, Long>{

	Optional<ConfiguracioEntity> findByEmpresa(EmpresaEntity empresa);

}
