/**
 * 
 */
package es.limit.cecocloud.logic.api.dto.util;

import java.io.Serializable;

/**
 * Implementació per defecte de la interfície IdentificableChild.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public abstract class AbstractIdentificableChild<PID extends Serializable, ID extends Serializable> extends AbstractIdentificable<ID> implements IdentificableChild<PID, ID> {

	protected PID parentId;

	@Override
	public PID getParentId() {
		return parentId;
	}
	@Override
	public void setParentId(PID parentId) {
		this.parentId = parentId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		AbstractIdentificableChild other = (AbstractIdentificableChild) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (parentId == null) {
			if (other.parentId != null)
				return false;
		} else if (!parentId.equals(other.parentId))
			return false;
		return true;
	}

}
