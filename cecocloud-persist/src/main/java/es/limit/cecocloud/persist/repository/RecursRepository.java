/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;
import java.util.Optional;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.RecursEntity;

/**
 * Repository per a gestionar les entitats de tipus recurs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface RecursRepository extends BaseRepository<RecursEntity, Long> {

	Optional<RecursEntity> findByEmbeddedClassName(String className);

	List<RecursEntity> findByEmbeddedClassNameStartingWith(String classNamePrefix);

}
