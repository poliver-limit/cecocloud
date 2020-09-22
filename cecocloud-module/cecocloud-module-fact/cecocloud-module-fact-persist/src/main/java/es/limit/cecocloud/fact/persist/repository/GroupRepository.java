/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.GroupEntity;

/**
 * Repository to manage entities from type Group.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface GroupRepository extends BaseRepository<GroupEntity, WithIdentificadorAndCodiPk<String>> {
}