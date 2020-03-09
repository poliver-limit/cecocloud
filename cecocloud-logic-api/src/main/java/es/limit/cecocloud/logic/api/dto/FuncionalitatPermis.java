/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import es.limit.base.boot.logic.api.dto.BaseBootPermission;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació per a assignar permisos a una funcionalitat-identificador.
 * 
 * @author Limit Tecnologies
 */
@Getter @Setter
public class FuncionalitatPermis {

	private Long funcionalitatIdentificadorId;
	private String codi;
	private String descripcio;
	private String modul;
	private FuncionalitatTipus tipus;
	private BaseBootPermission permission;
	private BaseBootPermission allowedPermission;

	public FuncionalitatPermis(
			Long funcionalitatIdentificadorId,
			String codi,
			String descripcio,
			String modul,
			FuncionalitatTipus tipus,
			BaseBootPermission permission,
			BaseBootPermission allowedPermission) {
		super();
		this.funcionalitatIdentificadorId = funcionalitatIdentificadorId;
		this.codi = codi;
		this.descripcio = descripcio;
		this.modul = modul;
		this.tipus = tipus;
		this.permission = permission;
		this.allowedPermission = allowedPermission;
	}

	public FuncionalitatPermis(
			Long funcionalitatIdentificadorId,
			String codi,
			String descripcio,
			String modul,
			FuncionalitatTipus tipus) {
		super();
		this.funcionalitatIdentificadorId = funcionalitatIdentificadorId;
		this.codi = codi;
		this.descripcio = descripcio;
		this.modul = modul;
		this.tipus = tipus;
	}

	public FuncionalitatPermis() {
		super();
	}

}
