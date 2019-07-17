/**
 * 
 */
package es.limit.cecocloud.persist.entity;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import lombok.Getter;

/**
 * Entitat de base de dades abstracta que representa una entitat filla.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@MappedSuperclass
public abstract class AbstractChildChildEntity<P1 extends AbstractEntity<?, ?>, P2 extends AbstractEntity<?, ?>, E, PK extends Serializable> extends AbstractEntity<E, PK> {

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	/*@JoinColumn(
			name = "parent_id",
			foreignKey = @ForeignKey(name = "child_parent_fk"))*/
	protected P1 parent1;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	/*@JoinColumn(
			name = "parent_id",
			foreignKey = @ForeignKey(name = "child_parent_fk"))*/
	protected P2 parent2;

	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		AbstractChildEntity other = (AbstractChildEntity)obj;
		return Objects.equals(parent, other.getParent()) && getId() != null && getId().equals(other.getId());
	}*/

}
