/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.module;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import es.limit.cecocloud.logic.api.dto.FuncionalitatTipus;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFont;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFontImpl;
import es.limit.cecocloud.logic.api.module.Modul;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;
import es.limit.cecocloud.rrhh.logic.api.dto.Calendari;
import es.limit.cecocloud.rrhh.logic.api.dto.TipusDia;
import es.limit.cecocloud.rrhh.logic.api.dto.Zona;
import es.limit.cecocloud.rrhh.logic.service.EmpresaIdentificadorSyncServiceImpl;

/**
 * Registre del mòdul de recursos humans.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class RrhhModuleRegister {

	private static Map<String, FuncionalitatCodiFont> funcionalitats;
	private static ModuleInfo moduleInfo;

	static {
		funcionalitats = new HashMap<String, FuncionalitatCodiFont>();
		funcionalitats.put(
				"REH_CALEND",
				new FuncionalitatCodiFontImpl(
						"REH_CALEND",
						FuncionalitatTipus.MANTENIMENT,
						"Calendaris",
						Modul.rrhh,
						Arrays.asList(Calendari.class),
						Arrays.asList(TipusDia.class)));
				/*new FuncionalitatCodiFontImpl(
						"REH_CATEGO",
						FuncionalitatTipus.MANTENIMENT,
						"Categories",
						Modul.rrhh,
						Arrays.asList(Categoria.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"REH_GRUFES",
						FuncionalitatTipus.MANTENIMENT,
						"Grups festius",
						Modul.rrhh,
						Arrays.asList(GrupFestiu.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"REH_HORARI",
						FuncionalitatTipus.MANTENIMENT,
						"Horaris",
						Modul.rrhh,
						Arrays.asList(Horari.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"REH_INTERV",
						FuncionalitatTipus.MANTENIMENT,
						"Intervals",
						Modul.rrhh,
						Arrays.asList(Interval.class),
						Arrays.asList(
								Calendari.class,
								Zona.class,
								Operari.class)),
				new FuncionalitatCodiFontImpl(
						"REH_NODE",
						FuncionalitatTipus.MANTENIMENT,
						"Nodes",
						Modul.rrhh,
						Arrays.asList(Node.class),
						Arrays.asList(
								Zona.class,
								Servidor.class)),
				new FuncionalitatCodiFontImpl(
						"REH_OPERAR",
						FuncionalitatTipus.MANTENIMENT,
						"Operaris",
						Modul.rrhh,
						Arrays.asList(Operari.class),
						Arrays.asList(Horari.class)),
				new FuncionalitatCodiFontImpl(
						"REH_PARAME",
						FuncionalitatTipus.MANTENIMENT,
						"Parametres",
						Modul.rrhh,
						Arrays.asList(Parametre.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"REH_RECGRU",
						FuncionalitatTipus.MANTENIMENT,
						"Recursos Grup",
						Modul.rrhh,
						Arrays.asList(RecursGrup.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"REH_REGIM",
						FuncionalitatTipus.MANTENIMENT,
						"Regims",
						Modul.rrhh,
						Arrays.asList(Regim.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"REH_REGDIA",
						FuncionalitatTipus.MANTENIMENT,
						"Registres Diaris",
						Modul.rrhh,
						Arrays.asList(RegistreDiari.class),
						Arrays.asList(
								Calendari.class,
								Operari.class,
								Horari.class,
								Regim.class,
								Seccio.class,
								Categoria.class,
								Subcategoria.class)),
				new FuncionalitatCodiFontImpl(
						"REH_SECCIO",
						FuncionalitatTipus.MANTENIMENT,
						"Seccions",
						Modul.rrhh,
						Arrays.asList(Seccio.class),
						Arrays.asList(SeccioGrup.class)),
				new FuncionalitatCodiFontImpl(
						"REH_SECGRU",
						FuncionalitatTipus.MANTENIMENT,
						"Seccions Grup",
						Modul.rrhh,
						Arrays.asList(SeccioGrup.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"REH_SERVID",
						FuncionalitatTipus.MANTENIMENT,
						"Servidors",
						Modul.rrhh,
						Arrays.asList(Servidor.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"REH_SUBCAT",
						FuncionalitatTipus.MANTENIMENT,
						"Subcategories",
						Modul.rrhh,
						Arrays.asList(Subcategoria.class),
						Arrays.asList(Categoria.class)),
				new FuncionalitatCodiFontImpl(
						"REH_TIPDIA",
						FuncionalitatTipus.MANTENIMENT,
						"Tipus Dia",
						Modul.rrhh,
						Arrays.asList(TipusDia.class),
						Arrays.asList(Regim.class)),
				new FuncionalitatCodiFontImpl(
						"REH_TIPTRA",
						FuncionalitatTipus.MANTENIMENT,
						"Tipus Transaccio",
						Modul.rrhh,
						Arrays.asList(TipusTransaccio.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"REH_TRANSA",
						FuncionalitatTipus.MANTENIMENT,
						"Transaccions",
						Modul.rrhh,
						Arrays.asList(Transaccio.class),
						Arrays.asList(
								Operari.class,
								TipusTransaccio.class,
								Node.class)),
				new FuncionalitatCodiFontImpl(
						"REH_ZONA",
						FuncionalitatTipus.MANTENIMENT,
						"Zones",
						Modul.rrhh,
						Arrays.asList(Zona.class),
						Arrays.asList())
				));*/
		moduleInfo = new ModuleInfo(
				Modul.rrhh,
				Zona.class.getPackage().getName(),
				EmpresaIdentificadorSyncServiceImpl.class,
				funcionalitats);
		Modules.registerModule(moduleInfo);
	}

	public static ModuleInfo getModuleInfo() {
		return moduleInfo;
	}

}
