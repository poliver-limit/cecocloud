/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.util.List;

import es.limit.base.boot.logic.api.module.ModuleInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un mòdul.
 * 
 * @author Limit Tecnologies
 */
@Getter @Setter
public class ModuleFuncionalitatInfo {

	private ModuleInfo module;
	private List<FuncionalitatInfo> funcionalitats;

	public ModuleFuncionalitatInfo(
			ModuleInfo module,
			List<FuncionalitatInfo> funcionalitats) {
		super();
		this.module = module;
		this.funcionalitats = funcionalitats;
	}

//	public ModuleFuncionalitatInfo(
//			List<String> funcionalitatNames,
//			ModuleInfo module) {
//		super();
//		this.module = module;
//		this.funcionalitats = funcionalitatNames.stream().map(resourceName -> new FuncionalitatInfo(resourceName)).collect(Collectors.toList());
//	}
}
