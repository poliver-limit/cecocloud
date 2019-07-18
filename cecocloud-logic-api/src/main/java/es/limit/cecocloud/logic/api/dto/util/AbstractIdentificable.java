/**
 * 
 */
package es.limit.cecocloud.logic.api.dto.util;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Implementació per defecte de la interfície Identificable.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Embeddable
public abstract class AbstractIdentificable<ID extends Serializable> implements Identificable<ID> {

	protected ID id;

	@Override
	public ID getId() {
		return id;
	}
	@Override
	public void setId(ID id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		AbstractIdentificable other = (AbstractIdentificable) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
