/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.ParameterEntity;

/**
 * Repository to manage entities from type Parameter.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomParameterRepository")
public interface ParameterRepository extends BaseRepository<ParameterEntity, WithIdentificadorAndCodiPk<String>> {
}