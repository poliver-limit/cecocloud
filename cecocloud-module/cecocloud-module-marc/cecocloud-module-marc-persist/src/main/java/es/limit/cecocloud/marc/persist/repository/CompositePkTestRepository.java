/**
 * 
 */
package es.limit.cecocloud.marc.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.marc.logic.api.dto.CompositePkTest.CompositePkTestPk;
import es.limit.cecocloud.marc.persist.entity.CompositePkTestEntity;

/**
 * Repository per a gestionar les entitats de tipus cpktest.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface CompositePkTestRepository extends BaseRepository<CompositePkTestEntity, CompositePkTestPk> {

}
