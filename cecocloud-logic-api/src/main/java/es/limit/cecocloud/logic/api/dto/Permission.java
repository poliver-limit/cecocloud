/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un permís per a un SID.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class Permission {

	@NotNull
	private PermissionSidType sidType;
	@NotEmpty
	private String sidName;
	private boolean readGranted;
	private boolean writeGranted;
	private boolean createGranted;
	private boolean deleteGranted;
	private boolean adminGranted;
	private boolean syncGranted;

	public static enum PermissionSidType {
		PRINCIPAL,
		GRANTED_AUTHORITY
	}

}
