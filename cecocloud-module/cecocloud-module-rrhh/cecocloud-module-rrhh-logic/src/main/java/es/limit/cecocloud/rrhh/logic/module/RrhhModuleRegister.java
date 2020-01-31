/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.module;

import org.springframework.stereotype.Component;

import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;
import es.limit.cecocloud.rrhh.logic.api.dto.Zona;
import es.limit.cecocloud.rrhh.logic.api.module.RrhhModuleConfig;
import es.limit.cecocloud.rrhh.logic.service.EmpresaIdentificadorSyncServiceImpl;

/**
 * Registre del mòdul de recursos humans.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class RrhhModuleRegister {

	private static ModuleInfo moduleInfo = new ModuleInfo(
			RrhhModuleConfig.CODE,
			Zona.class.getPackage().getName(),
			EmpresaIdentificadorSyncServiceImpl.class);

	static {
		Modules.registerModule(moduleInfo);
	}

	public static ModuleInfo getModuleInfo() {
		return moduleInfo;
	}

}
