/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.module;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.base.boot.logic.api.module.ModuleInfo;
import es.limit.cecocloud.facturacio.logic.api.dto.Zona;
import es.limit.cecocloud.logic.api.module.Modules;


/**
 * Configuració del mòdul de marcatges.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class FacturacioModule {

	public static final String CODE = "fact";
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
