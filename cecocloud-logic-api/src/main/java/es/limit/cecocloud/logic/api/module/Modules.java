/**
 * 
 */
package es.limit.cecocloud.logic.api.module;

import es.limit.base.boot.logic.api.dto.Profile;
import es.limit.base.boot.logic.api.module.AbstractModules;
import es.limit.base.boot.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.dto.Companyia;

/**
 * Classe que gestiona els diferents mòduls disponibles.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class Modules extends AbstractModules {

	public static void registerModule(ModuleInfo moduleInfo) {
		if (!isInitialized()) {
			init(
					new String[] {
							"fact",
							"comp",
							"rrhh",
							"rrmm",
							"lici",
							"marc"
					},
					new String[] {
							Profile.class.getPackage().getName(),
							Companyia.class.getPackage().getName()
					});
		}
		register(moduleInfo);
	}

}
