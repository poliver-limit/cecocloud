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
public abstract class AbstractIdentificableChildChild<PID1 extends Serializable, PID2 extends Serializable, ID extends Serializable> extends AbstractIdentificable<ID> implements IdentificableChildChild<PID1, PID2, ID> {

	protected PID1 parentId1;
	protected PID2 parentId2;

	@Override
	public PID1 getParentId1() {
		return parentId1;
	}
	@Override
	public void setParentId1(PID1 parentId1) {
		this.parentId1 = parentId1;
	}
	@Override
	public PID2 getParentId2() {
		return parentId2;
	}
	@Override
	public void setParentId2(PID2 parentId2) {
		this.parentId2 = parentId2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((parentId1 == null) ? 0 : parentId1.hashCode());
		result = prime * result + ((parentId2 == null) ? 0 : parentId2.hashCode());
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
		AbstractIdentificableChildChild other = (AbstractIdentificableChildChild) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (parentId1 == null) {
			if (other.parentId1 != null)
				return false;
		} else if (!parentId1.equals(other.parentId1))
			return false;
		if (parentId2 == null) {
			if (other.parentId2 != null)
				return false;
		} else if (!parentId2.equals(other.parentId2))
			return false;
		return true;
	}

}
