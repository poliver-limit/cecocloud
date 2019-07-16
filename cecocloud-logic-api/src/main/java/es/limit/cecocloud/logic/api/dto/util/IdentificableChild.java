/**
 * 
 */
package es.limit.cecocloud.logic.api.dto.util;

import java.io.Serializable;

/**
 * Interfície que han d'implementar tots els DTOs identificables amb pare.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface IdentificableChild<PID extends Serializable, ID extends Serializable> extends Identificable<ID> {

	public PID getParentId();
	public void setParentId(PID parentId);

}
