/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;

/**
 * Repository per a gestionar les entitats de tipus empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface EmpresaRepository extends BaseRepository<EmpresaEntity, Long> {

	List<EmpresaEntity> findByIdentificador(IdentificadorEntity identificador);

	Optional<EmpresaEntity> findByIdentificadorAndEmbeddedCodi(IdentificadorEntity identificador, String codi);

}
