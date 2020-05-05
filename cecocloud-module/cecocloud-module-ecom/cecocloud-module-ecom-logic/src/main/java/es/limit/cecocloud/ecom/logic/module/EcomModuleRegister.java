/**
 * 
 */
package es.limit.cecocloud.ecom.logic.module;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFont;
import es.limit.cecocloud.logic.api.module.ModuleInfo;

/**
 * Registre del mòdul de facturació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class EcomModuleRegister {

	private static Map<String, FuncionalitatCodiFont> funcionalitats;
	private static ModuleInfo moduleInfo;

	static {
		funcionalitats = new HashMap<String, FuncionalitatCodiFont>();	
	}

	public static ModuleInfo getModuleInfo() {
		return moduleInfo;
	}

}