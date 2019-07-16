/**
 * 
 */
package es.limit.cecocloud.logic.api.dto.util;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Referència genèrica cap a un altre element del model.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class GenericReference<D extends Identificable<ID>, ID extends Serializable> implements Identificable<ID> {

	@NotNull
	protected ID id;
	protected String description;

	public GenericReference() {
		super();
	}
	public GenericReference(ID id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	@Override
	public ID getId() {
		return id;
	}
	@Override
	public void setId(ID id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public static <D extends Identificable<ID>, ID extends Serializable> GenericReference<D, ID> toGenericReference(D dto) {
		return new GenericReference<D, ID>(
				dto.getId(),
				"");
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
		GenericReference other = (GenericReference) obj;
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
