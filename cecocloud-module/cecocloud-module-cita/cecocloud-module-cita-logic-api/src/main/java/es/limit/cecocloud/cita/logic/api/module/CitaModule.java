/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.module;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.cita.logic.api.dto.Cita;
import es.limit.cecocloud.cita.logic.api.dto.Festiu;
import es.limit.cecocloud.cita.logic.api.dto.FestiuGrup;
import es.limit.cecocloud.cita.logic.api.dto.Horari;
import es.limit.cecocloud.cita.logic.api.dto.HorariInterval;
import es.limit.cecocloud.cita.logic.api.dto.PuntVendaHorari;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda;
import es.limit.cecocloud.logic.api.dto.FuncionalitatTipus;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFont;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFontImpl;
import es.limit.cecocloud.logic.api.module.Modul;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;
import es.limit.cecocloud.rrhh.logic.api.dto.GrupFestiu;

/**
 * Configuració del mòdul de cites.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class CitaModule {

	public static final String API_PATH = GenericController.API_PATH + "/cita";
	private static Map<String, FuncionalitatCodiFont> funcionalitats;
	private static ModuleInfo moduleInfo;

	static {
		funcionalitats = new HashMap<String, FuncionalitatCodiFont>();
		funcionalitats.put(
				"CIT_PUNVEN",
				new FuncionalitatCodiFontImpl(
						"CIT_PUNVEN",
						FuncionalitatTipus.MANTENIMENT,
						"Punts de venda",
						PuntVenda.class,
						Arrays.asList(
								FestiuGrup.class,
								Festiu.class,
								Horari.class,
								HorariInterval.class,
								PuntVendaHorari.class)));
		funcionalitats.put(
				"CIT_HORARI",
				new FuncionalitatCodiFontImpl(
						"CIT_HORARI",
						FuncionalitatTipus.MANTENIMENT,
						"Horaris",
						Horari.class,
						Arrays.asList(
								HorariInterval.class)));
		funcionalitats.put(
				"CIT_GRPFES",
				new FuncionalitatCodiFontImpl(
						"CIT_GRPFES",
						FuncionalitatTipus.MANTENIMENT,
						"Grups de festius",
						GrupFestiu.class,
						Arrays.asList(
								Festiu.class)));
		funcionalitats.put(
				"CIT_CITA",
				new FuncionalitatCodiFontImpl(
						"CIT_CITA",
						FuncionalitatTipus.MANTENIMENT,
						"Cites",
						Cita.class,
						Arrays.asList(
								PuntVenda.class)));
		moduleInfo = new ModuleInfo(
				Modul.cita,
				Cita.class.getPackage().getName(),
				null,
				null,
				funcionalitats);
		Modules.registerModule(moduleInfo);
	}

	public static ModuleInfo getModuleInfo() {
		return moduleInfo;
	}

}
