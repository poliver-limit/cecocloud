/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.util.List;

import es.limit.base.boot.logic.api.module.ModuleInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació de les funcionalitat-permis d'un mòdul.
 * 
 * @author Limit Tecnologies
 */
@Getter @Setter
public class FuncionalitatPermisModule {

	private ModuleInfo module;
	private List<FuncionalitatPermis> funcionalitats;

	public FuncionalitatPermisModule(
			ModuleInfo module,
			List<FuncionalitatPermis> funcionalitats) {
		super();
		this.module = module;
		this.funcionalitats = funcionalitats;
	}

}
