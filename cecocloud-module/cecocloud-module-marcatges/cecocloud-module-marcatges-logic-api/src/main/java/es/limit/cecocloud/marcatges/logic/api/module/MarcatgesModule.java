/**
 * 
 */
package es.limit.cecocloud.marcatges.logic.api.module;

import org.springframework.stereotype.Component;

import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;
import es.limit.cecocloud.marcatges.logic.api.dto.Marcatge;

/**
 * Configuració del mòdul de marcatges.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class MarcatgesModule {

	public static final String CODE = "marc";

	private static ModuleInfo moduleInfo = new ModuleInfo(
			CODE,
			Marcatge.class.getPackage().getName());

	static {
		Modules.registerModule(moduleInfo);
	}

	public static ModuleInfo getModuleInfo() {
		return moduleInfo;
	}

}
