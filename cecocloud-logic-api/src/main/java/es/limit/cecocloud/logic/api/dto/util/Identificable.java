/**
 * 
 */
package es.limit.cecocloud.logic.api.dto.util;

import java.io.Serializable;

/**
 * Interfície que han d'implementar tots els DTOs identificables.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface Identificable<ID extends Serializable> {

	public ID getId();
	public void setId(ID id);

}
