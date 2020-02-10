/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.module;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.logic.api.module.Modul;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;
import es.limit.cecocloud.marc.logic.api.dto.Marcatge;

/**
 * Configuració del mòdul de marcatges.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class MarcModule {

	public static final String API_PATH = GenericController.API_PATH + "/marc";

	private static ModuleInfo moduleInfo = new ModuleInfo(
			Modul.marc,
			Marcatge.class.getPackage().getName());

	static {
		Modules.registerModule(moduleInfo);
	}

	public static ModuleInfo getModuleInfo() {
		return moduleInfo;
	}

}
