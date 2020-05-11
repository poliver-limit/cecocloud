/**
 * 
 */
package es.limit.cecocloud.ecom.logic.module;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import es.limit.cecocloud.ecom.logic.api.dto.Article;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleFamilia;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleFamiliaEmpresa;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleGamma;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleMarca;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleModel;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleInformacio;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleTraduccio;
import es.limit.cecocloud.ecom.logic.api.dto.Empresa;
import es.limit.cecocloud.ecom.logic.api.dto.Iva;
import es.limit.cecocloud.ecom.logic.api.dto.Idioma;
import es.limit.cecocloud.ecom.logic.api.dto.Client;
import es.limit.cecocloud.ecom.logic.api.dto.PaisNif;
import es.limit.cecocloud.ecom.logic.api.dto.TipusAdresa;
import es.limit.cecocloud.ecom.logic.api.dto.CodiPostal;
import es.limit.cecocloud.ecom.logic.api.dto.FamiliaClient;
import es.limit.cecocloud.ecom.logic.api.dto.RegimIva;
import es.limit.cecocloud.ecom.logic.api.dto.TipusFacturacio;
import es.limit.cecocloud.ecom.logic.api.dto.TipusVenciment;
import es.limit.cecocloud.ecom.logic.api.dto.DocumentPagamentCobrament;



import es.limit.cecocloud.ecom.logic.service.DatabaseSyncServiceImpl;
import es.limit.cecocloud.ecom.logic.service.EmpresaIdentificadorSyncServiceImpl;
import es.limit.cecocloud.ecom.persist.entity.DocumentPagamentCobramentEntity;
import es.limit.cecocloud.logic.api.dto.FuncionalitatTipus;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFont;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFontImpl;
import es.limit.cecocloud.logic.api.module.Modul;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;

/**
 * Registre del mòdul de ecommerce.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class EcomModuleRegister {

	private static Map<String, FuncionalitatCodiFont> funcionalitats;
	private static ModuleInfo moduleInfo;

	static {
		funcionalitats = new HashMap<String, FuncionalitatCodiFont>();	
		funcionalitats.put(
				"COM_ARTICL",
				new FuncionalitatCodiFontImpl(
						"COM_ARTICL",
						FuncionalitatTipus.MANTENIMENT,
						"Articles (eCommerce)",
						Article.class,
						Arrays.asList(
								ArticleFamilia.class, 
								Iva.class, 
								ArticleModel.class, 
								ArticleGamma.class, 
								ArticleMarca.class)));
		funcionalitats.put(
				"COM_FAMART",
				new FuncionalitatCodiFontImpl(
						"COM_FAMART",
						FuncionalitatTipus.MANTENIMENT,
						"Articles família (eCommerce)",
						ArticleFamilia.class,
						Arrays.asList()));
		funcionalitats.put(
				"COM_EMFART",
				new FuncionalitatCodiFontImpl(
						"COM_EMFART",
						FuncionalitatTipus.MANTENIMENT,
						"Articles família empresa (eCommerce)",
						ArticleFamiliaEmpresa.class,
						Arrays.asList(ArticleFamilia.class)));
		funcionalitats.put(
				"COM_GAMART",
				new FuncionalitatCodiFontImpl(
						"COM_GAMART",
						FuncionalitatTipus.MANTENIMENT,
						"Articles gamma (eCommerce)",
						ArticleGamma.class,
						Arrays.asList()));
		funcionalitats.put(
				"COM_AINART",
				new FuncionalitatCodiFontImpl(
						"COM_AINART",
						FuncionalitatTipus.MANTENIMENT,
						"Articles informació (eCommerce)",
						ArticleInformacio.class,
						Arrays.asList()));
		funcionalitats.put(
				"COM_MARART",
				new FuncionalitatCodiFontImpl(
						"COM_MARART",
						FuncionalitatTipus.MANTENIMENT,
						"Articles marca (eCommerce)",
						ArticleMarca.class,
						Arrays.asList()));
		funcionalitats.put(
				"COM_MODART",
				new FuncionalitatCodiFontImpl(
						"COM_MODART",
						FuncionalitatTipus.MANTENIMENT,
						"Articles model (eCommerce)",
						ArticleModel.class,
						Arrays.asList()));
		funcionalitats.put(
				"COM_TRDART",
				new FuncionalitatCodiFontImpl(
						"COM_TRDART",
						FuncionalitatTipus.MANTENIMENT,
						"Articles traduccions (eCommerce)",
						ArticleTraduccio.class,
						Arrays.asList(
								Article.class,
								Idioma.class)));
		funcionalitats.put(
				"COM_CLI",
				new FuncionalitatCodiFontImpl(
						"COM_CLI",
						FuncionalitatTipus.MANTENIMENT,
						"Clients (eCommerce)",
						Client.class,
						Arrays.asList(
								PaisNif.class,
								TipusAdresa.class,
								CodiPostal.class,
								FamiliaClient.class,
								Idioma.class,
								Iva.class,
								RegimIva.class,
								TipusFacturacio.class,
								TipusVenciment.class,
								DocumentPagamentCobrament.class)));
		funcionalitats.put(
				"COM_IDI",
				new FuncionalitatCodiFontImpl(
						"COM_IDI",
						FuncionalitatTipus.MANTENIMENT,
						"Idiomes (eCommerce)",
						Idioma.class,
						Arrays.asList()));
		funcionalitats.put(
				"COM_IVA",
				new FuncionalitatCodiFontImpl(
						"COM_IVA",
						FuncionalitatTipus.MANTENIMENT,
						"Iva (eCommerce)",
						Iva.class,
						Arrays.asList()));
		funcionalitats.put(
				"COM_EMPRES",
				new FuncionalitatCodiFontImpl(
						"COM_EMPRES",
						FuncionalitatTipus.MANTENIMENT,
						"Empreses (eCommerce)",
						Empresa.class,
						Arrays.asList()));
		moduleInfo = new ModuleInfo(
				Modul.ecom,
				Article.class.getPackage().getName(),
				EmpresaIdentificadorSyncServiceImpl.class,
				DatabaseSyncServiceImpl.class,
				funcionalitats);
		Modules.registerModule(moduleInfo);
	}

	public static ModuleInfo getModuleInfo() {
		return moduleInfo;
	}

}