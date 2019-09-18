/**
 * 
 */
package es.limit.cecocloud.back.acl;

import org.springframework.security.acls.domain.DefaultPermissionFactory;

import es.limit.cecocloud.logic.api.acl.ExtendedPermission;

/**
 * Factoria per a crear instàncies de ExtendedPermission.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class ExtendedPermissionFactory extends DefaultPermissionFactory {

	public ExtendedPermissionFactory() {
		super();
		registerPublicPermissions(ExtendedPermission.class);
	}

}
