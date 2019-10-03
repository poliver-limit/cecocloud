/**
 * 
 */
package es.limit.cecocloud.persist.entity;

import java.io.Serializable;

import org.springframework.data.domain.Persistable;

/**
 * Entitat de base de dades abstracta amb clau primària composta.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface EmbeddableEntity<E, PK extends Serializable> extends Persistable<PK> {

	public void update(E embedded);
	public E getEmbedded();

}