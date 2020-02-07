/**
 * 
 */
package es.limit.cecocloud.logic.api.module;

import java.util.Arrays;

import es.limit.base.boot.logic.api.dto.Profile;
import es.limit.base.boot.logic.api.module.AbstractModules;
import es.limit.cecocloud.logic.api.dto.Identificador;

/**
 * Classe que gestiona els diferents mòduls disponibles a Cecocloud.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class Modules extends AbstractModules {

	public static void registerModule(ModuleInfo moduleInfo) {
		if (!isInitialized()) {
			init(
					Arrays.stream(Modul.values()).map(value -> value.name()).toArray(String[]::new),
					new String[] {
							Profile.class.getPackage().getName(),
							Identificador.class.getPackage().getName()
					});
		}
		register(moduleInfo);
	}

}
