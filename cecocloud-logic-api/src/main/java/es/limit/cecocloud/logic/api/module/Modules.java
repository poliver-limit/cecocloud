/**
 * 
 */
package es.limit.cecocloud.logic.api.module;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import es.limit.base.boot.logic.api.dto.Profile;
import es.limit.base.boot.logic.api.module.AbstractModules;
import es.limit.cecocloud.logic.api.dto.Identificador;
import lombok.extern.slf4j.Slf4j;

/**
 * Classe que gestiona els diferents mòduls disponibles a Cecocloud.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
public class Modules extends AbstractModules {

	private static Map<Class<?>, FuncionalitatCodiFont> funcionalitatPerRecursPrincipal = new HashMap<Class<?>, FuncionalitatCodiFont>();

	public static void registerModule(ModuleInfo moduleInfo) {
		if (!isInitialized()) {
			init(
					Arrays.stream(Modul.values()).map(value -> value.name()).toArray(String[]::new),
					new String[] {
							Profile.class.getPackage().getName(),
							Identificador.class.getPackage().getName()
					});
		}
		if (moduleInfo.getFuncionalitats() != null) {
			for (String funcionalitatCodi: moduleInfo.getFuncionalitats().keySet()) {
				FuncionalitatCodiFont funcionalitat = moduleInfo.getFuncionalitats().get(funcionalitatCodi);
				funcionalitatPerRecursPrincipal.put(
						funcionalitat.getRecursPrincipal(),
						funcionalitat);
			}
		}
		register(moduleInfo);
		log.info("Nou mòdul registrat: " + moduleInfo.getCode());
	}

	public static FuncionalitatCodiFont getFuncionalitatWithRecursPrincipal(Class<?> recursPrincipalClass) {
		return funcionalitatPerRecursPrincipal.get(recursPrincipalClass);
	}

}
