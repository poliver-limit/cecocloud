/**
 * 
 */
package es.limit.cecocloud.persist.repository;

/**
 * Interfície per a incloure el mètode refresh a dins un repositori spring-data.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface RefreshableRepository<E> {

	public void refresh(E entity);

}
