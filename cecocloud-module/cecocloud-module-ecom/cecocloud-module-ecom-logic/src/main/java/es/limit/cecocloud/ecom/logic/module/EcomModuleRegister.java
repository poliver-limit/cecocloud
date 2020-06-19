/**
 * 
 */
package es.limit.cecocloud.ecom.logic.module;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import es.limit.cecocloud.ecom.logic.api.dto.Albara;
import es.limit.cecocloud.ecom.logic.api.dto.AlbaraLinia;
import es.limit.cecocloud.ecom.logic.api.dto.Article;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleFamilia;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleFamiliaEmpresa;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleGamma;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleMarca;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleModel;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleInformacio;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleTraduccio;
import es.limit.cecocloud.ecom.logic.api.dto.Bestreta;
import es.limit.cecocloud.ecom.logic.api.dto.Iva;
import es.limit.cecocloud.ecom.logic.api.dto.Idioma;
import es.limit.cecocloud.ecom.logic.api.dto.Caixa;
import es.limit.cecocloud.ecom.logic.api.dto.CaixaMoviment;
import es.limit.cecocloud.ecom.logic.api.dto.Client;
import es.limit.cecocloud.ecom.logic.api.dto.Departament;
import es.limit.cecocloud.ecom.logic.api.dto.Divisa;
import es.limit.cecocloud.ecom.logic.api.dto.DocumentPagamentCobrament;
import es.limit.cecocloud.ecom.logic.api.dto.Empresa;
import es.limit.cecocloud.ecom.logic.api.dto.Factura;
import es.limit.cecocloud.ecom.logic.api.dto.FacturaBase;
import es.limit.cecocloud.ecom.logic.api.dto.PaisNif;
import es.limit.cecocloud.ecom.logic.api.dto.TipusAdresa;
import es.limit.cecocloud.ecom.logic.api.dto.TipusRisc;
import es.limit.cecocloud.ecom.logic.api.dto.TipusUnitat;
import es.limit.cecocloud.ecom.logic.api.dto.CodiPostal;
import es.limit.cecocloud.ecom.logic.api.dto.FamiliaClient;
import es.limit.cecocloud.ecom.logic.api.dto.FamiliaProveidor;
import es.limit.cecocloud.ecom.logic.api.dto.Magatzem;
import es.limit.cecocloud.ecom.logic.api.dto.MagatzemArticle;
import es.limit.cecocloud.ecom.logic.api.dto.MagatzemPeriode;
import es.limit.cecocloud.ecom.logic.api.dto.NaturalesaPagamentCobrament;
import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
import es.limit.cecocloud.ecom.logic.api.dto.Pais;
import es.limit.cecocloud.ecom.logic.api.dto.PeuDocument;
import es.limit.cecocloud.ecom.logic.api.dto.Pressupost;
import es.limit.cecocloud.ecom.logic.api.dto.PressupostLinia;
import es.limit.cecocloud.ecom.logic.api.dto.Proveidor;
import es.limit.cecocloud.ecom.logic.api.dto.Provincia;
import es.limit.cecocloud.ecom.logic.api.dto.PuntVenda;
import es.limit.cecocloud.ecom.logic.api.dto.RegimIva;
import es.limit.cecocloud.ecom.logic.api.dto.SerieCompra;
import es.limit.cecocloud.ecom.logic.api.dto.SerieVenda;
import es.limit.cecocloud.ecom.logic.api.dto.Stock;
import es.limit.cecocloud.ecom.logic.api.dto.TipusFacturacio;
import es.limit.cecocloud.ecom.logic.api.dto.TipusVenciment;
import es.limit.cecocloud.ecom.logic.api.dto.Transportista;
import es.limit.cecocloud.ecom.logic.api.dto.Vehicle;
import es.limit.cecocloud.ecom.logic.api.dto.Venciment;
import es.limit.cecocloud.ecom.logic.api.dto.VencimentPagat;
import es.limit.cecocloud.ecom.logic.service.EmpresaIdentificadorSyncServiceImpl;
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

	@SuppressWarnings("unused")
	private static Map<String, FuncionalitatCodiFont> funcionalitats;
	private static ModuleInfo moduleInfo;

	static {
		funcionalitats = new HashMap<String, FuncionalitatCodiFont>();	
		funcionalitats.put(
			"COM_ALB",
			new FuncionalitatCodiFontImpl(
					"COM_ALB",
					FuncionalitatTipus.MANTENIMENT,
					"Albarans (eCommerce)",
					Albara.class,
					Arrays.asList(
							Empresa.class,
							PuntVenda.class,
							Operari.class,
							SerieVenda.class,
							Magatzem.class,
							MagatzemPeriode.class,
							Divisa.class,
							CodiPostal.class,
							Client.class,
							Pressupost.class,
							Iva.class,
							Idioma.class,
							Pais.class,
							Provincia.class,
							DocumentPagamentCobrament.class,
							PaisNif.class,
							TipusAdresa.class)));
		funcionalitats.put(
				"COM_LAC",
				new FuncionalitatCodiFontImpl(
						"COM_LAC",
						FuncionalitatTipus.MANTENIMENT,
						"Albarà linies (eCommerce)",
						AlbaraLinia.class,
						Arrays.asList(
								Empresa.class,
								Albara.class,
								Article.class,
								Iva.class)));
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
				"COM_APC",
				new FuncionalitatCodiFontImpl(
						"COM_APC",
						FuncionalitatTipus.MANTENIMENT,
						"Bestretes (eCommerce)",
						Bestreta.class,
						Arrays.asList(
								Empresa.class,
								Pressupost.class,
								Caixa.class)));
		funcionalitats.put(
				"COM_CXA",
				new FuncionalitatCodiFontImpl(
						"COM_CXA",
						FuncionalitatTipus.MANTENIMENT,
						"Caixes (eCommerce)",
						Caixa.class,
						Arrays.asList(
								Empresa.class)));
		funcionalitats.put(
				"COM_MDC",
				new FuncionalitatCodiFontImpl(
						"COM_MDC",
						FuncionalitatTipus.MANTENIMENT,
						"Moviments de caixa (eCommerce)",
						CaixaMoviment.class,
						Arrays.asList(
								Empresa.class,
								Caixa.class,
								Operari.class,
								Divisa.class,
								DocumentPagamentCobrament.class,
								Pressupost.class)));
		funcionalitats.put(
				"COM_CPO",
				new FuncionalitatCodiFontImpl(
						"COM_CPO",
						FuncionalitatTipus.MANTENIMENT,
						"Codis postal (eCommerce)",
						CodiPostal.class,
						Arrays.asList(
								Pais.class,
								Provincia.class)));
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
				"COM_FMC",
				new FuncionalitatCodiFontImpl(
						"COM_FMC",
						FuncionalitatTipus.MANTENIMENT,
						"Famílies client (eCommerce)",
						FamiliaClient.class,
						Arrays.asList(TipusRisc.class)));
		funcionalitats.put(
				"COM_DEP",
				new FuncionalitatCodiFontImpl(
						"COM_DEP",
						FuncionalitatTipus.MANTENIMENT,
						"Departaments (eCommerce)",
						Departament.class,
						Arrays.asList(
								Empresa.class)));
		funcionalitats.put(
				"COM_DIV",
				new FuncionalitatCodiFontImpl(
						"COM_DIV",
						FuncionalitatTipus.MANTENIMENT,
						"Divises (eCommerce)",
						Divisa.class,
						Arrays.asList()));
		funcionalitats.put(
				"COM_DPG",
				new FuncionalitatCodiFontImpl(
						"COM_DPG",
						FuncionalitatTipus.MANTENIMENT,
						"Documents de pagament/cobrament (eCommerce)",
						DocumentPagamentCobrament.class,
						Arrays.asList(
								NaturalesaPagamentCobrament.class,
								Iva.class,
								RegimIva.class)));
		funcionalitats.put(
				"COM_NPG",
				new FuncionalitatCodiFontImpl(
						"COM_NPG",
						FuncionalitatTipus.MANTENIMENT,
						"Naturaleses del pagament/cobrament (eCommerce)",
						NaturalesaPagamentCobrament.class,
						Arrays.asList()));
		funcionalitats.put(
				"COM_EMP",
				new FuncionalitatCodiFontImpl(
						"COM_EMP",
						FuncionalitatTipus.MANTENIMENT,
						"Empreses (eCommerce)",
						Empresa.class,
						Arrays.asList(
								Divisa.class)));
		funcionalitats.put(
				"COM_FAC",
				new FuncionalitatCodiFontImpl(
						"COM_FAC",
						FuncionalitatTipus.MANTENIMENT,
						"Factures (eCommerce)",
						Factura.class,
						Arrays.asList(
								Empresa.class,
								SerieVenda.class,
								Client.class,
								CodiPostal.class,
								Divisa.class,
								RegimIva.class,
								TipusVenciment.class,
								Pressupost.class,
								PaisNif.class,
								TipusAdresa.class,
								Idioma.class,
								Pais.class,
								Provincia.class,
								DocumentPagamentCobrament.class,
								PuntVenda.class)));
		funcionalitats.put(
				"COM_BFC",
				new FuncionalitatCodiFontImpl(
						"COM_BFC",
						FuncionalitatTipus.MANTENIMENT,
						"Bases factura (eCommerce)",
						FacturaBase.class,
						Arrays.asList(
								Empresa.class,
								SerieVenda.class,
								Factura.class,
								Iva.class)));
		funcionalitats.put(
				"COM_FPR",
				new FuncionalitatCodiFontImpl(
						"COM_FPR",
						FuncionalitatTipus.MANTENIMENT,
						"Famílies proveïdor (eCommerce)",
						FamiliaProveidor.class,
						Arrays.asList()));
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
				"COM_RGI",
				new FuncionalitatCodiFontImpl(
						"COM_RGI",
						FuncionalitatTipus.MANTENIMENT,
						"Règims iva (eCommerce)",
						RegimIva.class,
						Arrays.asList()));
		funcionalitats.put(
				"COM_MAG",
				new FuncionalitatCodiFontImpl(
						"COM_MAG",
						FuncionalitatTipus.MANTENIMENT,
						"Magatzems (eCommerce)",
						Magatzem.class,
						Arrays.asList()));		
		funcionalitats.put(
				"COM_MAR",
				new FuncionalitatCodiFontImpl(
						"COM_MAR",
						FuncionalitatTipus.MANTENIMENT,
						"Magatzems-Articles (eCommerce)",
						MagatzemArticle.class,
						Arrays.asList(
								Magatzem.class,
								Article.class)));
		funcionalitats.put(
				"COM_PMG",
				new FuncionalitatCodiFontImpl(
						"COM_PMG",
						FuncionalitatTipus.MANTENIMENT,
						"Magatzem períodes (eCommerce)",
						MagatzemPeriode.class,
						Arrays.asList(
								Magatzem.class)));
		funcionalitats.put(
				"COM_PAI",
				new FuncionalitatCodiFontImpl(
						"COM_PAI",
						FuncionalitatTipus.MANTENIMENT,
						"Països (eCommerce)",
						Pais.class,
						Arrays.asList()));
		funcionalitats.put(
				"COM_PAINIF",
				new FuncionalitatCodiFontImpl(
						"COM_PAINIF",
						FuncionalitatTipus.MANTENIMENT,
						"Països Nif (eCommerce)",
						PaisNif.class,
						Arrays.asList()));
		funcionalitats.put(
				"COM_PED",
				new FuncionalitatCodiFontImpl(
						"COM_PED",
						FuncionalitatTipus.MANTENIMENT,
						"Peus document (eCommerce)",
						PeuDocument.class,
						Arrays.asList(
								Empresa.class,
								SerieCompra.class)));
		funcionalitats.put(
				"COM_PRE",
				new FuncionalitatCodiFontImpl(
						"COM_PRE",
						FuncionalitatTipus.MANTENIMENT,
						"Pressupostos (eCommerce)",
						Pressupost.class,
						Arrays.asList(
								Empresa.class,
								SerieVenda.class,
								Client.class,								
								Iva.class,
								CodiPostal.class,
								Divisa.class,
								Magatzem.class,
								Idioma.class,
								Pais.class,
								Provincia.class,
//								PuntVenda.class,
								DocumentPagamentCobrament.class)));
		funcionalitats.put(
				"COM_LPR",
				new FuncionalitatCodiFontImpl(
						"COM_LPR",
						FuncionalitatTipus.MANTENIMENT,
						"Pressupostos Linies (eCommerce)",
						PressupostLinia.class,
						Arrays.asList(
								Empresa.class,
								Pressupost.class,
								Article.class)));
		funcionalitats.put(
				"COM_PRO",
				new FuncionalitatCodiFontImpl(
						"COM_PRO",
						FuncionalitatTipus.MANTENIMENT,
						"Proveïdors (eCommerce)",
						Proveidor.class,
						Arrays.asList(
								RegimIva.class,
								CodiPostal.class,
								TipusVenciment.class,
								Divisa.class,
								DocumentPagamentCobrament.class,
								FamiliaProveidor.class)));
		funcionalitats.put(
				"COM_PRV",
				new FuncionalitatCodiFontImpl(
						"COM_PRV",
						FuncionalitatTipus.MANTENIMENT,
						"Provincies (eCommerce)",
						Provincia.class,
						Arrays.asList(Pais.class)));
		funcionalitats.put(
				"COM_PTV",
				new FuncionalitatCodiFontImpl(
						"COM_PTV",
						FuncionalitatTipus.MANTENIMENT,
						"Punts de venda (eCommerce)",
						PuntVenda.class,
						Arrays.asList(
								Empresa.class,
								Caixa.class,
								Divisa.class,
								Client.class,
								DocumentPagamentCobrament.class,
								Magatzem.class,
								Operari.class,
								SerieVenda.class)));
		funcionalitats.put(
				"COM_SCP",
				new FuncionalitatCodiFontImpl(
						"COM_SCP",
						FuncionalitatTipus.MANTENIMENT,
						"Serie de compra (eCommerce)",
						SerieCompra.class,
						Arrays.asList(
								Empresa.class,								
								Magatzem.class)));
		funcionalitats.put(
				"COM_SER",
				new FuncionalitatCodiFontImpl(
						"COM_SER",
						FuncionalitatTipus.MANTENIMENT,
						"Serie de venda (eCommerce)",
						SerieVenda.class,
						Arrays.asList(
								Empresa.class,
								PeuDocument.class,
								Magatzem.class,
								Departament.class)));
//		Pendent de afegir funcionalitat
//		funcionalitats.put(
//				"COM_STO",
//				new FuncionalitatCodiFontImpl(
//						"COM_STO",
//						FuncionalitatTipus.MANTENIMENT,
//						"Stocks (eCommerce)",
//						Stock.class,
//						Arrays.asList(
//								Magatzem.class,
//								MagatzemPeriode.class,
//								Article.class)));
		funcionalitats.put(
				"COM_TIPADR",
				new FuncionalitatCodiFontImpl(
						"COM_TIPADR",
						FuncionalitatTipus.MANTENIMENT,
						"Tipus adreces (eCommerce)",
						TipusAdresa.class,
						Arrays.asList()));
		funcionalitats.put(
				"COM_TFC",
				new FuncionalitatCodiFontImpl(
						"COM_TFC",
						FuncionalitatTipus.MANTENIMENT,
						"Tipus de facturació (eCommerce)",
						TipusFacturacio.class,
						Arrays.asList()));
		funcionalitats.put(
				"COM_TRI",
				new FuncionalitatCodiFontImpl(
						"COM_TRI",
						FuncionalitatTipus.MANTENIMENT,
						"Tipus de riscos (eCommerce)",
						TipusRisc.class,
						Arrays.asList()));
		funcionalitats.put(
				"COM_TUN",
				new FuncionalitatCodiFontImpl(
						"COM_TUN",
						FuncionalitatTipus.MANTENIMENT,
						"Tipus d'unitats (eCommerce)",
						TipusUnitat.class,
						Arrays.asList()));
		funcionalitats.put(
				"COM_TVE",
				new FuncionalitatCodiFontImpl(
						"COM_TVE",
						FuncionalitatTipus.MANTENIMENT,
						"Tipus de venciments (eCommerce)",
						TipusVenciment.class,
						Arrays.asList()));
		funcionalitats.put(
				"COM_TRA",
				new FuncionalitatCodiFontImpl(
						"COM_TRA",
						FuncionalitatTipus.MANTENIMENT,
						"Transportistes (eCommerce)",
						Transportista.class,
						Arrays.asList(
								CodiPostal.class,
								Divisa.class,
								Proveidor.class)));
		funcionalitats.put(
				"COM_MTR",
				new FuncionalitatCodiFontImpl(
						"COM_MTR",
						FuncionalitatTipus.MANTENIMENT,
						"Vehicles (eCommerce)",
						Vehicle.class,
						Arrays.asList(
								Transportista.class)));
		funcionalitats.put(
				"COM_VEN",
				new FuncionalitatCodiFontImpl(
						"COM_VEN",
						FuncionalitatTipus.MANTENIMENT,
						"Venciments (eCommerce)",
						Venciment.class,
						Arrays.asList(
								Empresa.class,
								SerieVenda.class,
								Factura.class,
								Divisa.class)));
		funcionalitats.put(
				"COM_VCX",
				new FuncionalitatCodiFontImpl(
						"COM_VCX",
						FuncionalitatTipus.MANTENIMENT,
						"Venciments pagats (eCommerce)",
						VencimentPagat.class,
						Arrays.asList(
								Empresa.class,
								SerieVenda.class,
								Factura.class,
								Caixa.class,
								CaixaMoviment.class,
								Venciment.class)));
		moduleInfo = new ModuleInfo(
				Modul.ecom,
				Article.class.getPackage().getName(),
				EmpresaIdentificadorSyncServiceImpl.class,
				funcionalitats);
		Modules.registerModule(moduleInfo);
	}

	public static ModuleInfo getModuleInfo() {
		return moduleInfo;
	}

}