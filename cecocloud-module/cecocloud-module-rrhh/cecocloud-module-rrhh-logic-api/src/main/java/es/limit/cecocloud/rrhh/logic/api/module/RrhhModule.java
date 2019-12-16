/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.module;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.base.boot.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;
import es.limit.cecocloud.rrhh.logic.api.dto.Zona;


/**
 * Configuració del mòdul de rrhh.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class RrhhModule {

	public static final String CODE = "rrhh";
	public static final String API_PATH = GenericController.API_PATH + "/" + CODE;

	private static ModuleInfo moduleInfo = new ModuleInfo(
			CODE,
			Zona.class.getPackage().getName());

	static {
		Modules.registerModule(moduleInfo);
	}

	public static ModuleInfo getModuleInfo() {
		return moduleInfo;
	}

}
