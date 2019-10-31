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

	public static final Permission PRINT = new ExtendedPermission(1 << 5, 'P');
	public static final Permission AUX1 = new ExtendedPermission(1 << 6, '1');
	public static final Permission AUX2 = new ExtendedPermission(1 << 7, '2');
	public static final Permission AUX3 = new ExtendedPermission(1 << 8, '3');
	public static final Permission AUX4 = new ExtendedPermission(1 << 9, '4');
	public static final Permission AUX5 = new ExtendedPermission(1 << 10, '5');
//	public static final Permission SYNC = new ExtendedPermission(1 << 5, 'S');

	protected ExtendedPermission(int mask) {
		super(mask);
	}

	protected ExtendedPermission(int mask, char code) {
		super(mask, code);
	}

}
