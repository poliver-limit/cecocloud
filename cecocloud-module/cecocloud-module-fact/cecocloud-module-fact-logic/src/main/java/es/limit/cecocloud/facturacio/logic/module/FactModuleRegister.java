/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.module;

import org.springframework.stereotype.Component;

import es.limit.cecocloud.facturacio.logic.api.dto.Zona;
import es.limit.cecocloud.facturacio.logic.api.module.FactModuleConfig;
import es.limit.cecocloud.facturacio.logic.service.EmpresaIdentificadorSyncServiceImpl;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;

/**
 * Registre del mòdul de facturació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class FactModuleRegister {

	private static ModuleInfo moduleInfo = new ModuleInfo(
			FactModuleConfig.CODE,
			Zona.class.getPackage().getName(),
			EmpresaIdentificadorSyncServiceImpl.class);

	static {
		Modules.registerModule(moduleInfo);
	}

	public static ModuleInfo getModuleInfo() {
		return moduleInfo;
	}

}
