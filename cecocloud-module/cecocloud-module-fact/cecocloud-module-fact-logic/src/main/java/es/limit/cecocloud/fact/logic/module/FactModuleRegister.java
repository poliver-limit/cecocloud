/**
 * 
 */
package es.limit.cecocloud.fact.logic.module;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import es.limit.cecocloud.fact.logic.api.dto.Albara;
import es.limit.cecocloud.fact.logic.api.dto.Empresa;
import es.limit.cecocloud.fact.logic.api.dto.Zona;
import es.limit.cecocloud.fact.logic.service.EmpresaIdentificadorSyncServiceImpl;
import es.limit.cecocloud.logic.api.dto.FuncionalitatTipus;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFont;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFontImpl;
import es.limit.cecocloud.logic.api.module.Modul;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;

/**
 * Registre del mòdul de facturació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class FactModuleRegister {

	private static Map<String, FuncionalitatCodiFont> funcionalitats;
	private static ModuleInfo moduleInfo;

	static {
		funcionalitats = new HashMap<String, FuncionalitatCodiFont>();
		funcionalitats.put(
				"FAC_ALBARA",
				new FuncionalitatCodiFontImpl(
						"FAC_ALBARA",
						FuncionalitatTipus.MANTENIMENT,
						"Albarans",
						Modul.fact,
						Arrays.asList(Albara.class),
						Arrays.asList(Empresa.class)));
				/*new FuncionalitatCodiFontImpl(
						"FAC_APLICA",
						FuncionalitatTipus.MANTENIMENT,
						"Aplicadors",
						Modul.fact,
						Arrays.asList(Aplicador.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_APLCLI",
						FuncionalitatTipus.MANTENIMENT,
						"Aplicadors-Client",
						Modul.fact,
						Arrays.asList(AplicadorClient.class),
						Arrays.asList(
								Aplicador.class, 
								Client.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_ARENEG",
						FuncionalitatTipus.MANTENIMENT,
						"Àrea negocis",
						Modul.fact,
						Arrays.asList(AreaNegoci.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_ARTICL",
						FuncionalitatTipus.MANTENIMENT,
						"Articles",
						Modul.fact,
						Arrays.asList(Article.class),
						Arrays.asList(
								ArticleFamilia.class, 
								Iva.class, 
								ArticleModel.class, 
								ArticleGamma.class, 
								ArticleMarca.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_FAMART",
						FuncionalitatTipus.MANTENIMENT,
						"Articles família",
						Modul.fact,
						Arrays.asList(ArticleFamilia.class),
						Arrays.asList(
								RecursGrup.class, 
								FamiliaCost.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_EMFART",
						FuncionalitatTipus.MANTENIMENT,
						"Articles família empresa",
						Modul.fact,
						Arrays.asList(ArticleFamiliaEmpresa.class),
						Arrays.asList(ArticleFamilia.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_GAMART",
						FuncionalitatTipus.MANTENIMENT,
						"Articles gamma",
						Modul.fact,
						Arrays.asList(ArticleGamma.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_MARART",
						FuncionalitatTipus.MANTENIMENT,
						"Articles marca",
						Modul.fact,
						Arrays.asList(ArticleMarca.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_MODART",
						FuncionalitatTipus.MANTENIMENT,
						"Articles model",
						Modul.fact,
						Arrays.asList(ArticleModel.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_BANCS",
						FuncionalitatTipus.MANTENIMENT,
						"Bancs",
						Modul.fact,
						Arrays.asList(Banc.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_CLIENT",
						FuncionalitatTipus.MANTENIMENT,
						"Clients",
						Modul.fact,
						Arrays.asList(Client.class),
						Arrays.asList(
								Divisa.class, 
								TipusVenciment.class, 
								RegimIva.class, 
								Rappel.class, 
								DocumentPagamentCobrament.class, 
								TipusFacturacio.class, 
								FamiliaClient.class, 
								CodiPostal.class, 
								Idioma.class,
								Zona.class,
								SerieVenda.class,
								Iva.class,
								Tarifa.class,
								Banc.class,
								OficinaBancaria.class,
								Transportista.class,
								es.limit.cecocloud.rrhh.logic.api.dto.Operari.class,
								ClasseRetencio.class,
								ClientAdresa.class,
								Organitzacio.class,
								TarifaDescompte.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_ADRCLI",
						FuncionalitatTipus.MANTENIMENT,
						"ClientsAdresa",
						Modul.fact,
						Arrays.asList(ClientAdresa.class),
						Arrays.asList(
								Client.class, 
								CodiPostal.class, 
								SubClient.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_CP",
						FuncionalitatTipus.MANTENIMENT,
						"Codis postals",
						Modul.fact,
						Arrays.asList(CodiPostal.class),
						Arrays.asList(
								Pais.class, 
								Provincia.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_EMPCCM",
						FuncionalitatTipus.MANTENIMENT,
						"Comptes comptables empresa",
						Modul.fact,
						Arrays.asList(CompteComptableEmpresa.class),
						Arrays.asList(Client.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_EMPCCR",
						FuncionalitatTipus.MANTENIMENT,
						"Comptes corrents empresa",
						Modul.fact,
						Arrays.asList(CompteCorrentEmpresa.class),
						Arrays.asList(
								Client.class, 
								Banc.class, 
								OficinaBancaria.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_DEPART",
						FuncionalitatTipus.MANTENIMENT,
						"Departaments",
						Modul.fact,
						Arrays.asList(Departament.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_DEPCLI",
						FuncionalitatTipus.MANTENIMENT,
						"DepartamentsClient",
						Modul.fact,
						Arrays.asList(DepartamentClient.class),
						Arrays.asList(
								Client.class, 
								CodiPostal.class, 
								SubClient.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_DIVISA",
						FuncionalitatTipus.MANTENIMENT,
						"Divises",
						Modul.fact,
						Arrays.asList(Divisa.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_DOCP-C",
						FuncionalitatTipus.MANTENIMENT,
						"Documents de pagament/cobrament",
						Modul.fact,
						Arrays.asList(DocumentPagamentCobrament.class),
						Arrays.asList(
								NaturalesaPagamentCobrament.class, 
								Iva.class, 
								RegimIva.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_EMPRES",
						FuncionalitatTipus.MANTENIMENT,
						"Empreses (Facturació)",
						Modul.fact,
						Arrays.asList(Empresa.class),
						Arrays.asList(
								CodiPostal.class, 
								Divisa.class, 
								Magatzem.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_FAMCLI",
						FuncionalitatTipus.MANTENIMENT,
						"Famílies client",
						Modul.fact,
						Arrays.asList(FamiliaClient.class),
						Arrays.asList(TipusRisc.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_FAMCOS",
						FuncionalitatTipus.MANTENIMENT,
						"Famílies cost",
						Modul.fact,
						Arrays.asList(FamiliaCost.class),
						Arrays.asList(ArticleFamilia.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_FAMPRO",
						FuncionalitatTipus.MANTENIMENT,
						"Famílies proveidor",
						Modul.fact,
						Arrays.asList(FamiliaProveidor.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_FINFAC",
						FuncionalitatTipus.MANTENIMENT,
						"Final factures",
						Modul.fact,
						Arrays.asList(FinalFactura.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_IDIOMA",
						FuncionalitatTipus.MANTENIMENT,
						"Idiomes",
						Modul.fact,
						Arrays.asList(Idioma.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_IVA",
						FuncionalitatTipus.MANTENIMENT,
						"Iva",
						Modul.fact,
						Arrays.asList(Iva.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_MAGATZ",
						FuncionalitatTipus.MANTENIMENT,
						"Magatzems",
						Modul.fact,
						Arrays.asList(Magatzem.class),
						Arrays.asList(
								CodiPostal.class, 
								Divisa.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_MAGPER",
						FuncionalitatTipus.MANTENIMENT,
						"Magatzems període",
						Modul.fact,
						Arrays.asList(MagatzemPeriode.class),
						Arrays.asList(Magatzem.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_NATP-C",
						FuncionalitatTipus.MANTENIMENT,
						"Naturaleses de pagament/cobrament",
						Modul.fact,
						Arrays.asList(NaturalesaPagamentCobrament.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_OFIBAN",
						FuncionalitatTipus.MANTENIMENT,
						"Oficines bancaries",
						Modul.fact,
						Arrays.asList(OficinaBancaria.class),
						Arrays.asList(
								CodiPostal.class, 
								Banc.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_PAIS",
						FuncionalitatTipus.MANTENIMENT,
						"Països",
						Modul.fact,
						Arrays.asList(Pais.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_PEUDOC",
						FuncionalitatTipus.MANTENIMENT,
						"Peus de document",
						Modul.fact,
						Arrays.asList(PeuDocument.class),
						Arrays.asList(SerieCompra.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_PROJEC",
						FuncionalitatTipus.MANTENIMENT,
						"Projectes",
						Modul.fact,
						Arrays.asList(Projecte.class),
						Arrays.asList(Divisa.class, 
								ProjecteTipus.class, 
								es.limit.cecocloud.rrhh.logic.api.dto.Operari.class, 
								SerieVenda.class,
								Client.class,
								SubClient.class,
								ClientAdresa.class,
								CodiPostal.class,
								ClasseRetencio.class,
								AreaNegoci.class,
								Magatzem.class,
								Zona.class,
								FinalFactura.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_PROTIP",
						FuncionalitatTipus.MANTENIMENT,
						"Projectes Tipus",
						Modul.fact,
						Arrays.asList(ProjecteTipus.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_PROVEI",
						FuncionalitatTipus.MANTENIMENT,
						"Proveidors",
						Modul.fact,
						Arrays.asList(Proveidor.class),
						Arrays.asList(
								RegimIva.class,
								CodiPostal.class,
								TipusVenciment.class,
								Divisa.class,
								DocumentPagamentCobrament.class,
								FamiliaProveidor.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_PROVIN",
						FuncionalitatTipus.MANTENIMENT,
						"Províncies",
						Modul.fact,
						Arrays.asList(Provincia.class),
						Arrays.asList(Pais.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_RAPPEL",
						FuncionalitatTipus.MANTENIMENT,
						"Rappels",
						Modul.fact,
						Arrays.asList(Rappel.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_REGIVA",
						FuncionalitatTipus.MANTENIMENT,
						"Règims iva",
						Modul.fact,
						Arrays.asList(RegimIva.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_SECEMP",
						FuncionalitatTipus.MANTENIMENT,
						"Seccions empresa",
						Modul.fact,
						Arrays.asList(SeccioEmpresa.class),
						Arrays.asList(
								ArticleFamilia.class,
								Seccio.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_SERCOM",
						FuncionalitatTipus.MANTENIMENT,
						"Sèries de compra",
						Modul.fact,
						Arrays.asList(SerieCompra.class),
						Arrays.asList(Magatzem.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_SERINT",
						FuncionalitatTipus.MANTENIMENT,
						"Sèries intracomunitàries",
						Modul.fact,
						Arrays.asList(SerieIntracomunitaria.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_SERVEN",
						FuncionalitatTipus.MANTENIMENT,
						"Sèries de venda",
						Modul.fact,
						Arrays.asList(SerieVenda.class),
						Arrays.asList(
								PeuDocument.class,
								Magatzem.class,
								Departament.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_SITCOM",
						FuncionalitatTipus.MANTENIMENT,
						"Situacions comercials",
						Modul.fact,
						Arrays.asList(SituacioComercial.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_SITINI",
						FuncionalitatTipus.MANTENIMENT,
						"Situacions inicials",
						Modul.fact,
						Arrays.asList(SituacioInicial.class),
						Arrays.asList(
								Magatzem.class,
								Article.class,
								Divisa.class,
								MagatzemPeriode.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_SUBCLI",
						FuncionalitatTipus.MANTENIMENT,
						"Subclients",
						Modul.fact,
						Arrays.asList(SubClient.class),
						Arrays.asList(
								Client.class,
								CodiPostal.class,
								Tarifa.class,
								TarifaDescompte.class,
								Iva.class,
								TipusComissio.class,
								RegimIva.class,
								TipusVenciment.class,
								ClasseRetencio.class,
								Zona.class,
								es.limit.cecocloud.rrhh.logic.api.dto.Operari.class,
								ClientAdresa.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_SUBVEN",
						FuncionalitatTipus.MANTENIMENT,
						"Subvencions",
						Modul.fact,
						Arrays.asList(Subvencio.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_TARIFA",
						FuncionalitatTipus.MANTENIMENT,
						"Tarifes",
						Modul.fact,
						Arrays.asList(Tarifa.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_TARDES",
						FuncionalitatTipus.MANTENIMENT,
						"Tarifes descompte",
						Modul.fact,
						Arrays.asList(TarifaDescompte.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_TIPCOM",
						FuncionalitatTipus.MANTENIMENT,
						"Tipus de comissió",
						Modul.fact,
						Arrays.asList(TipusComissio.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_TIPFAC",
						FuncionalitatTipus.MANTENIMENT,
						"Tipus de facturació",
						Modul.fact,
						Arrays.asList(TipusFacturacio.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_TIPINF",
						FuncionalitatTipus.MANTENIMENT,
						"Tipus incidencia factura",
						Modul.fact,
						Arrays.asList(TipusIncidenciaFactura.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_TIPP-C",
						FuncionalitatTipus.MANTENIMENT,
						"Tipus de proveïdor/client",
						Modul.fact,
						Arrays.asList(TipusProveidorClient.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_TIPRIS",
						FuncionalitatTipus.MANTENIMENT,
						"Tipus de riscos",
						Modul.fact,
						Arrays.asList(TipusRisc.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_TIPVEN",
						FuncionalitatTipus.MANTENIMENT,
						"Tipus de venciments",
						Modul.fact,
						Arrays.asList(TipusVenciment.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_TRANSP",
						FuncionalitatTipus.MANTENIMENT,
						"Transportistes",
						Modul.fact,
						Arrays.asList(Transportista.class),
						Arrays.asList(
								CodiPostal.class,
								Divisa.class,
								Proveidor.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_UBICAC",
						FuncionalitatTipus.MANTENIMENT,
						"Ubicacions",
						Modul.fact,
						Arrays.asList(Ubicacio.class),
						Arrays.asList(Magatzem.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_UBIART",
						FuncionalitatTipus.MANTENIMENT,
						"Ubicacions articles",
						Modul.fact,
						Arrays.asList(UbicacioArticle.class),
						Arrays.asList(
								Ubicacio.class,
								Article.class,
								Magatzem.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_UNITIP",
						FuncionalitatTipus.MANTENIMENT,
						"Unitats tipus",
						Modul.fact,
						Arrays.asList(UnitatTipus.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_VEHICL",
						FuncionalitatTipus.MANTENIMENT,
						"Vehicles",
						Modul.fact,
						Arrays.asList(Vehicle.class),
						Arrays.asList(Transportista.class)),
				new FuncionalitatCodiFontImpl(
						"FAC_ZONA",
						FuncionalitatTipus.MANTENIMENT,
						"Zones",
						Modul.fact,
						Arrays.asList(Zona.class),
						Arrays.asList()),
				
				new FuncionalitatCodiFontImpl(
						"FAC_CERCLI",
						FuncionalitatTipus.MANTENIMENT,
						"Cercador clients",
						Modul.fact,
						Arrays.asList(Client.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_CLARET",
						FuncionalitatTipus.MANTENIMENT,
						"Classes de retencions",
						Modul.fact,
						Arrays.asList(ClasseRetencio.class),
						Arrays.asList()),
				new FuncionalitatCodiFontImpl(
						"FAC_ORG",
						FuncionalitatTipus.MANTENIMENT,
						"Organitzacions",
						Modul.fact,
						Arrays.asList(Organitzacio.class),
						Arrays.asList())
		//		new FuncionalitatCodiFontImpl(
		//				"FAC_PAINIF",
		//				FuncionalitatTipus.MANTENIMENT,
		//				"Països NIF",
		//				Modul.fact,
		//				Arrays.asList(PaisNif.class),
		//				Arrays.asList()),
		//		new FuncionalitatCodiFontImpl(
		//				"FAC_TIPADR",
		//				FuncionalitatTipus.MANTENIMENT,
		//				"Tipus adreça",
		//				Modul.fact,
		//				Arrays.asList(TipusAdresa.class),
		//				Arrays.asList()),
		//		new FuncionalitatCodiFontImpl(
		//				"FAC_TIPCOM",
		//				FuncionalitatTipus.MANTENIMENT,
		//				"Tipus comissions",
		//				Modul.fact,
		//				Arrays.asList(TipusComissio.class),
		//				Arrays.asList())*/
		moduleInfo = new ModuleInfo(
				Modul.fact,
				Zona.class.getPackage().getName(),
				EmpresaIdentificadorSyncServiceImpl.class,
				funcionalitats);
		Modules.registerModule(moduleInfo);
	}

	public static ModuleInfo getModuleInfo() {
		return moduleInfo;
	}

}
