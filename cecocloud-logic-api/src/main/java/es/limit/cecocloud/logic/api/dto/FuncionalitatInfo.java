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
	private FuncionalitatTipus tipus;
	private BaseBootPermission permission;

	public FuncionalitatInfo(
			String codi,
			String descripcio,
			FuncionalitatTipus tipus,
			BaseBootPermission permission) {
		super();
		this.codi = codi;
		this.descripcio = descripcio;
		this.tipus = tipus;
		this.permission = permission;
	}
	
	public FuncionalitatInfo(
			String codi,
			String descripcio,
			FuncionalitatTipus tipus) {
		super();
		this.codi = codi;
		this.descripcio = descripcio;
		this.tipus = tipus;
	}
	
	public FuncionalitatInfo() {
		super();
	}
}
