/**
 * 
 */
package es.limit.cecocloud.persist.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * Entitat de base de dades abstracta.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@MappedSuperclass
public abstract class AbstractEntity<E, PK extends Serializable> extends AbstractPersistable<PK> implements EmbeddableEntity<E, PK> {

	@Version
	@Getter(AccessLevel.NONE)
	private long version;

	public abstract void update(E embedded);
	public abstract E getEmbedded();

}
