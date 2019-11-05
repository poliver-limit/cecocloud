/**
 * 
 */
package es.limit.cecocloud.logic.api.module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe que gestiona els diferents mòduls disponibles.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class Modules {

	private static final String[] AVAILABLE_MODULES = {
		"fact",
		"comp",
		"rrhh",
		"rrmm",
		"lici",
		"marc"
	};

	private static List<ModuleInfo> modules = new ArrayList<ModuleInfo>();

	public static void registerModule(ModuleInfo moduleInfo) {
		boolean isValid = Arrays.stream(AVAILABLE_MODULES).anyMatch(moduleInfo.getCode()::equals);
		if (isValid) {
			modules.add(moduleInfo);
		} else {
			throw new RuntimeException("Invalid module: " + moduleInfo.getCode());
		}
	}

	public static List<ModuleInfo> getModules() {
		return modules;
	}

}
