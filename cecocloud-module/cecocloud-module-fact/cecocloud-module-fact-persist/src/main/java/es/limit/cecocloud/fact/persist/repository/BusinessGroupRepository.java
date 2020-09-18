/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.BusinessGroupEntity;

/**
 * Repository to manage entities from type Business Group.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface BusinessGroupRepository extends BaseRepository<BusinessGroupEntity, WithIdentificadorAndCodiPk<String>> {
}