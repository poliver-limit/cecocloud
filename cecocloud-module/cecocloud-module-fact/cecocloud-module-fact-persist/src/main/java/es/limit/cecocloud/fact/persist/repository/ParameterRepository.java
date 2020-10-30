/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import java.util.Optional;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.ParameterEntity;
import es.limit.cecocloud.fact.persist.entity.IdentificadorEntity;

/**
 * Repository to manage entities from type Parameter.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface ParameterRepository extends BaseRepository<ParameterEntity, WithIdentificadorAndCodiPk<String>> {
	
	Optional<ParameterEntity> findByIdentificadorAndEmbeddedCodi(IdentificadorEntity identificador, String codi);	
	
}