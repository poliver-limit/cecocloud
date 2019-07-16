/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Repository base per a totes les entitats.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@NoRepositoryBean
public interface BaseRepository<E, ID> extends JpaRepository<E, ID>, JpaSpecificationExecutor<E> {

}
