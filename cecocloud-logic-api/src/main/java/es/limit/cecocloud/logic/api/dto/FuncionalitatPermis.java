/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import es.limit.base.boot.logic.api.dto.BaseBootPermission;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una funcionalitat-permis.
 * 
 * @author Limit Tecnologies
 */
@Getter @Setter
public class FuncionalitatPermis {

	private Long id;
	private String codi;
	private String descripcio;
	private String modul;
	private FuncionalitatTipus tipus;
	private BaseBootPermission permission;
	private BaseBootPermission allowedPermission;

	public FuncionalitatPermis(
			Long id,
			String codi,
			String descripcio,
			String modul,
			FuncionalitatTipus tipus,
			BaseBootPermission permission,
			BaseBootPermission allowedPermission) {
		super();
		this.id = id;
		this.codi = codi;
		this.descripcio = descripcio;
		this.modul = modul;
		this.tipus = tipus;
		this.permission = permission;
		this.allowedPermission = allowedPermission;
	}
	
	public FuncionalitatPermis(
			Long id,
			String codi,
			String descripcio,
			String modul,
			FuncionalitatTipus tipus) {
		super();
		this.id = id;
		this.codi = codi;
		this.descripcio = descripcio;
		this.modul = modul;
		this.tipus = tipus;
	}
	
	public FuncionalitatPermis() {
		super();
	}
}
