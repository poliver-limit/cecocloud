/**
 * 
 */
package es.limit.cecocloud.persist.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.util.ProxyUtils;
import org.springframework.lang.Nullable;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * Entitat de base de dades abstracta amb clau primària composta.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@MappedSuperclass
public abstract class AbstractCompositePkEntity<E, PK extends Serializable> implements EmbeddableEntity<E, PK> {

	@EmbeddedId private @Nullable PK id;
	@Version
	@Getter(AccessLevel.NONE)
	private long version;

	public abstract void update(E embedded);
	public abstract E getEmbedded();

	@Nullable
	public PK getId() {
		return id;
	}

	protected void setId(@Nullable PK id) {
		this.id = id;
	}

	@Transient
	public boolean isNew() {
		return null == getId();
	}

	@Override
	public String toString() {
		return String.format("Entity of type %s with id: %s", this.getClass().getName(), getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!getClass().equals(ProxyUtils.getUserClass(obj))) {
			return false;
		}
		AbstractPersistable<?> that = (AbstractPersistable<?>) obj;
		return null == this.getId() ? false : this.getId().equals(that.getId());
	}

	@Override
	public int hashCode() {
		int hashCode = 17;
		hashCode += null == getId() ? 0 : getId().hashCode() * 31;
		return hashCode;
	}

}