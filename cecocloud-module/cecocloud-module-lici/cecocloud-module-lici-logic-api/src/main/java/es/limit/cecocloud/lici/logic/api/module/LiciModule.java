/**
 * 
 */
package es.limit.cecocloud.lici.logic.api.module;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.lici.logic.api.dto.Licitacio;
import es.limit.cecocloud.logic.api.module.Modul;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;

/**
 * Configuració del mòdul de licitacions.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class LiciModule {

	public static final String CODE = Modul.lici.name();
	public static final String API_PATH = GenericController.API_PATH + "/lici";

	private static ModuleInfo moduleInfo = new ModuleInfo(
			CODE,
			Licitacio.class.getPackage().getName());

	static {
		Modules.registerModule(moduleInfo);
	}

	public static ModuleInfo getModuleInfo() {
		return moduleInfo;
	}

}
