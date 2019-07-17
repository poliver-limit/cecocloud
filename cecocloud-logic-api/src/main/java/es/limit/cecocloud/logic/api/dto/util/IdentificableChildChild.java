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
public interface IdentificableChildChild<PID1 extends Serializable, PID2 extends Serializable, ID extends Serializable> extends Identificable<ID> {

	public PID1 getParentId1();
	public void setParentId1(PID1 parentId);
	public PID2 getParentId2();
	public void setParentId2(PID2 parentId);

}
