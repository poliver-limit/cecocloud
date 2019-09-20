/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import es.limit.cecocloud.logic.api.dto.util.AbstractIdentificable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Informació d'un permís per a un SID.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@NoArgsConstructor
public class Permission extends AbstractIdentificable<String> {

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

	public void setId(String id) {
		this.id = id;
		if (id != null && !id.isEmpty()) {
			this.sidType = (id.startsWith("P")) ? PermissionSidType.PRINCIPAL : PermissionSidType.GRANTED_AUTHORITY;
			this.sidName = id.substring(1);
		}
	}

	@Builder
    public Permission(String id) {
		setId(id);
    }

	@Builder
    public Permission(PermissionSidType sidType, String sidName) {
		this.sidType = sidType;
		this.sidName = sidName;
		id = ((this.sidType == PermissionSidType.PRINCIPAL) ? "P" : "A") + sidName;
    }

	public static enum PermissionSidType {
		PRINCIPAL,
		GRANTED_AUTHORITY
	}

}
