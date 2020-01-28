/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import es.limit.base.boot.logic.api.dto.BaseBootPermission;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un recurs (permisos per rol).
 * 
 * @author Limit Tecnologies
 */
@Getter @Setter
public class FuncionalitatInfo {

	private String codi;
	private String descripcio;
	private BaseBootPermission permission;

	public FuncionalitatInfo(
			String codi,
			String descripcio,
			BaseBootPermission permission) {
		super();
		this.codi = codi;
		this.descripcio = descripcio;
		this.permission = permission;
	}
	
	public FuncionalitatInfo(
			String codi,
			String descripcio) {
		super();
		this.codi = codi;
		this.descripcio = descripcio;
	}
	
	public FuncionalitatInfo() {
		super();
	}
}
