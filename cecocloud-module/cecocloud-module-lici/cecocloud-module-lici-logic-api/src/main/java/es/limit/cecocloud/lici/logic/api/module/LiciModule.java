/**
 * 
 */
package es.limit.cecocloud.lici.logic.api.module;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.lici.logic.api.dto.Configuracio;
import es.limit.cecocloud.lici.logic.api.dto.Licitacio;
import es.limit.cecocloud.logic.api.dto.FuncionalitatTipus;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFont;
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
	private static Map<String, FuncionalitatCodiFont> funcionalitats;
	private static ModuleInfo moduleInfo;

	static {
		funcionalitats = new HashMap<String, FuncionalitatCodiFont>();
		funcionalitats.put(
				"LIC_CONFIG",
				new FuncionalitatCodiFontImpl(
						"LIC_CONFIG",
						FuncionalitatTipus.MANTENIMENT,
						"Configuracions",
						Configuracio.class,
						Arrays.asList()));
		funcionalitats.put(
				"LIC_LICITA",
				new FuncionalitatCodiFontImpl(
						"LIC_LICITA",
						FuncionalitatTipus.MANTENIMENT,
						"Licitacions",
						Licitacio.class,
						Arrays.asList()));
		moduleInfo = new ModuleInfo(
				Modul.lici,
				Licitacio.class.getPackage().getName(),
				null,
				null,
				funcionalitats);
		Modules.registerModule(moduleInfo);
	}

	public static ModuleInfo getModuleInfo() {
		return moduleInfo;
	}

}
