/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import org.springframework.data.repository.NoRepositoryBean;

/**
 * Repository base per a totes les entitats que implementa la interfície RefreshableRepository.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@NoRepositoryBean
public interface BaseRefreshableRepository<E, ID> extends BaseRepository<E, ID>, RefreshableRepository<E> {

}
