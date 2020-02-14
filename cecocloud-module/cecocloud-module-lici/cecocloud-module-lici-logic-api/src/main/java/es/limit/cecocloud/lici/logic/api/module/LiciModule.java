/**
 * 
 */
package es.limit.cecocloud.lici.logic.api.module;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.lici.logic.api.dto.Configuracio;
import es.limit.cecocloud.lici.logic.api.dto.Licitacio;
import es.limit.cecocloud.logic.api.dto.FuncionalitatTipus;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFontImpl;
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

	public static final String API_PATH = GenericController.API_PATH + "/lici";

	private static ModuleInfo moduleInfo = new ModuleInfo(
			Modul.lici,
			Licitacio.class.getPackage().getName(),
			null,
			Arrays.asList(
					new FuncionalitatCodiFontImpl(
							"LIC_CONFIG",
							FuncionalitatTipus.MANTENIMENT,
							"Configuracions",
							Modul.lici,
							Arrays.asList(Configuracio.class),
							Arrays.asList()),
					new FuncionalitatCodiFontImpl(
							"LIC_LICITA",
							FuncionalitatTipus.MANTENIMENT,
							"Licitacions",
							Modul.lici,
							Arrays.asList(Licitacio.class),
							Arrays.asList())
					));

	static {
		Modules.registerModule(moduleInfo);
	}

	public static ModuleInfo getModuleInfo() {
		return moduleInfo;
	}

}
