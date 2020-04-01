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
import es.limit.cecocloud.rrhh.logic.api.dto.Categoria;
import es.limit.cecocloud.rrhh.logic.api.dto.Empresa;
import es.limit.cecocloud.rrhh.logic.api.dto.GrupFestiu;
import es.limit.cecocloud.rrhh.logic.api.dto.Horari;
import es.limit.cecocloud.rrhh.logic.api.dto.Interval;
import es.limit.cecocloud.rrhh.logic.api.dto.MantenimentDeTipus;
import es.limit.cecocloud.rrhh.logic.api.dto.Node;
import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
import es.limit.cecocloud.rrhh.logic.api.dto.Parametre;
import es.limit.cecocloud.rrhh.logic.api.dto.RecursGrup;
import es.limit.cecocloud.rrhh.logic.api.dto.Regim;
import es.limit.cecocloud.rrhh.logic.api.dto.RegistreDiari;
import es.limit.cecocloud.rrhh.logic.api.dto.Seccio;
import es.limit.cecocloud.rrhh.logic.api.dto.SeccioGrup;
import es.limit.cecocloud.rrhh.logic.api.dto.Servidor;
import es.limit.cecocloud.rrhh.logic.api.dto.Subcategoria;
import es.limit.cecocloud.rrhh.logic.api.dto.TipusDia;
import es.limit.cecocloud.rrhh.logic.api.dto.TipusTransaccio;
import es.limit.cecocloud.rrhh.logic.api.dto.Transaccio;
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
						Calendari.class,
						Arrays.asList(TipusDia.class)));
		funcionalitats.put(
				"REH_CATEGO",
				new FuncionalitatCodiFontImpl(
						"REH_CATEGO",
						FuncionalitatTipus.MANTENIMENT,
						"Categories",
						Categoria.class,
						Arrays.asList()));
		funcionalitats.put(
				"REH_EMP",
				new FuncionalitatCodiFontImpl(
						"REH_EMP",
						FuncionalitatTipus.MANTENIMENT,
						"Empreses",
						Empresa.class,
						Arrays.asList()));
		funcionalitats.put(
				"REH_GRUFES",
				new FuncionalitatCodiFontImpl(
						"REH_GRUFES",
						FuncionalitatTipus.MANTENIMENT,
						"Grups festius",
						GrupFestiu.class,
						Arrays.asList()));
		funcionalitats.put(
				"REH_HORARI",
				new FuncionalitatCodiFontImpl(
						"REH_HORARI",
						FuncionalitatTipus.MANTENIMENT,
						"Horaris",
						Horari.class,
						Arrays.asList()));
		funcionalitats.put(
				"REH_INTERV",
				new FuncionalitatCodiFontImpl(
						"REH_INTERV",
						FuncionalitatTipus.MANTENIMENT,
						"Intervals",
						Interval.class,
						Arrays.asList(
								Calendari.class,
								Zona.class,
								Operari.class)));
		funcionalitats.put(
				"REH_MANTIP",
				new FuncionalitatCodiFontImpl(
						"REH_MANTIP",
						FuncionalitatTipus.MANTENIMENT,
						"Manteniment de tipus",
						MantenimentDeTipus.class,
						Arrays.asList()));
		funcionalitats.put(
				"REH_NODE",
				new FuncionalitatCodiFontImpl(
						"REH_NODE",
						FuncionalitatTipus.MANTENIMENT,
						"Nodes",
						Node.class,
						Arrays.asList(
								Zona.class,
								Servidor.class)));
		funcionalitats.put(
				"REH_OPERAR",
				new FuncionalitatCodiFontImpl(
						"REH_OPERAR",
						FuncionalitatTipus.MANTENIMENT,
						"Operaris",
						Operari.class,
						Arrays.asList(Horari.class)));
		funcionalitats.put(
				"REH_PARAME",
				new FuncionalitatCodiFontImpl(
						"REH_PARAME",
						FuncionalitatTipus.MANTENIMENT,
						"Parametres",
						Parametre.class,
						Arrays.asList()));
		funcionalitats.put(
				"REH_RECGRU",
				new FuncionalitatCodiFontImpl(
						"REH_RECGRU",
						FuncionalitatTipus.MANTENIMENT,
						"Recursos Grup",
						RecursGrup.class,
						Arrays.asList()));
		funcionalitats.put(
				"REH_REGIM",
				new FuncionalitatCodiFontImpl(
						"REH_REGIM",
						FuncionalitatTipus.MANTENIMENT,
						"Regims",
						Regim.class,
						Arrays.asList()));
		funcionalitats.put(
				"REH_REGDIA",
				new FuncionalitatCodiFontImpl(
						"REH_REGDIA",
						FuncionalitatTipus.MANTENIMENT,
						"Registres Diaris",
						RegistreDiari.class,
						Arrays.asList(
								Calendari.class,
								Operari.class,
								Horari.class,
								Regim.class,
								Seccio.class,
								Categoria.class,
								Subcategoria.class,
								Empresa.class)));
		funcionalitats.put(
				"REH_SECCIO",
				new FuncionalitatCodiFontImpl(
						"REH_SECCIO",
						FuncionalitatTipus.MANTENIMENT,
						"Seccions",
						Seccio.class,
						Arrays.asList(SeccioGrup.class)));
		funcionalitats.put(
				"REH_SECGRU",
				new FuncionalitatCodiFontImpl(
						"REH_SECGRU",
						FuncionalitatTipus.MANTENIMENT,
						"Seccions Grup",
						SeccioGrup.class,
						Arrays.asList()));
		funcionalitats.put(
				"REH_SERVID",
				new FuncionalitatCodiFontImpl(
						"REH_SERVID",
						FuncionalitatTipus.MANTENIMENT,
						"Servidors",
						Servidor.class,
						Arrays.asList()));
		funcionalitats.put(
				"REH_SUBCAT",
				new FuncionalitatCodiFontImpl(
						"REH_SUBCAT",
						FuncionalitatTipus.MANTENIMENT,
						"Subcategories",
						Subcategoria.class,
						Arrays.asList(Categoria.class)));
		funcionalitats.put(
				"REH_TIPDIA",
				new FuncionalitatCodiFontImpl(
						"REH_TIPDIA",
						FuncionalitatTipus.MANTENIMENT,
						"Tipus Dia",
						TipusDia.class,
						Arrays.asList(Regim.class)));
		funcionalitats.put(
				"REH_TIPTRA",
				new FuncionalitatCodiFontImpl(
						"REH_TIPTRA",
						FuncionalitatTipus.MANTENIMENT,
						"Tipus Transaccio",
						TipusTransaccio.class,
						Arrays.asList()));
		funcionalitats.put(
				"REH_TRANSA",
				new FuncionalitatCodiFontImpl(
						"REH_TRANSA",
						FuncionalitatTipus.MANTENIMENT,
						"Transaccions",
						Transaccio.class,
						Arrays.asList(
								Operari.class,
								TipusTransaccio.class,
								Node.class,
								Empresa.class)));
		funcionalitats.put(
				"REH_ZONA",
				new FuncionalitatCodiFontImpl(
						"REH_ZONA",
						FuncionalitatTipus.MANTENIMENT,
						"Zones",
						Zona.class,
						Arrays.asList()));
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
