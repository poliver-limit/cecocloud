/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Implementació de la interfície RefreshableRepository.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class RefreshableRepositoryImpl<E> implements RefreshableRepository<E> {

    @PersistenceContext
    private EntityManager em;

	@Override
	public void refresh(E entity) {
		em.refresh(entity);
	}

}
