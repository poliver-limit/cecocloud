/**
 * 
 */
package es.limit.cecocloud.persist.entity;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * Entitat de base de dades abstracta que representa una entitat arrel.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@MappedSuperclass
public abstract class AbstractEntity<E, PK extends Serializable> extends AbstractPersistable<PK> {

	@Embedded
	protected E embedded;

	@Version
	@Getter(AccessLevel.NONE)
	private long version;

	public void update(E embedded) {
		this.embedded = embedded;
	}

}
