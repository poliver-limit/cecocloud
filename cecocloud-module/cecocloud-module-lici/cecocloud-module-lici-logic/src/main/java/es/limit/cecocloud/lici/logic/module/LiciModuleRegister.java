/**
 * 
 */
package es.limit.cecocloud.lici.logic.module;

import org.springframework.stereotype.Component;

import es.limit.cecocloud.lici.logic.api.dto.Licitacio;
import es.limit.cecocloud.logic.api.module.Modul;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;

/**
 * Registre del mòdul de licitació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class LiciModuleRegister {
	
	private static ModuleInfo moduleInfo = new ModuleInfo(
			Modul.lici,
			Licitacio.class.getPackage().getName());
	
	static {
		Modules.registerModule(moduleInfo);
	}

	public static ModuleInfo getModuleInfo() {
		return moduleInfo;
	}
	

}
