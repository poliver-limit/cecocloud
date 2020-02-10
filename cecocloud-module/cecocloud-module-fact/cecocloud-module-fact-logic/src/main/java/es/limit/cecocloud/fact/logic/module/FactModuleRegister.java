/**
 * 
 */
package es.limit.cecocloud.fact.logic.module;

import org.springframework.stereotype.Component;

import es.limit.cecocloud.fact.logic.api.dto.Zona;
import es.limit.cecocloud.fact.logic.service.EmpresaIdentificadorSyncServiceImpl;
import es.limit.cecocloud.logic.api.module.Modul;
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
			Modul.fact,
			Zona.class.getPackage().getName(),
			EmpresaIdentificadorSyncServiceImpl.class,
			null); // TODO definir funcionalitats

	static {
		Modules.registerModule(moduleInfo);
	}

	public static ModuleInfo getModuleInfo() {
		return moduleInfo;
	}

}
