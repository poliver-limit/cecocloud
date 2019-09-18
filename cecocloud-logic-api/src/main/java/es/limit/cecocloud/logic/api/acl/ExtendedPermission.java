/**
 * 
 */
package es.limit.cecocloud.logic.api.acl;

import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.model.Permission;

/**
 * Permisos addicionals als que proporciona per defecte Spring Security.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@SuppressWarnings("serial")
public class ExtendedPermission extends BasePermission {

	public static final Permission SYNC = new ExtendedPermission(1 << 5, 'S');

	protected ExtendedPermission(int mask) {
		super(mask);
	}

	protected ExtendedPermission(int mask, char code) {
		super(mask, code);
	}

}
