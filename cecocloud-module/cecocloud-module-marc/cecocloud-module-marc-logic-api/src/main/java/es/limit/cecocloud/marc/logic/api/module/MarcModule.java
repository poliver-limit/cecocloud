/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.module;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.base.boot.logic.api.permission.ExtendedPermission;
import es.limit.cecocloud.logic.api.dto.FuncionalitatTipus;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFont;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFontImpl;
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
	private static Map<String, FuncionalitatCodiFont> funcionalitats;
	private static ModuleInfo moduleInfo;

	static {
		funcionalitats = new HashMap<String, FuncionalitatCodiFont>();
		funcionalitats.put(
				"MAR_MARCAT",
				new FuncionalitatCodiFontImpl(
						"MAR_MARCAT",
						FuncionalitatTipus.MANTENIMENT,
						"Marcatges",
						Modul.marc,
						Arrays.asList(Marcatge.class),
						Arrays.asList(),
						Arrays.asList(
								ExtendedPermission.READ,
								ExtendedPermission.CREATE)));
		moduleInfo = new ModuleInfo(
				Modul.marc,
				Marcatge.class.getPackage().getName(),
				null,
				funcionalitats);
		Modules.registerModule(moduleInfo);
	}

	public static ModuleInfo getModuleInfo() {
		return moduleInfo;
	}

}
