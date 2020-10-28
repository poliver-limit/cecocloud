/**
 * 
 */
package es.limit.cecocloud.fact.logic.module;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import es.limit.cecocloud.fact.logic.api.dto.*;
import es.limit.cecocloud.fact.logic.service.EmpresaIdentificadorSyncServiceImpl;
import es.limit.cecocloud.logic.api.dto.FuncionalitatTipus;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFont;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFontImpl;
import es.limit.cecocloud.logic.api.module.Modul;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;
import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
import es.limit.cecocloud.rrhh.logic.api.dto.RecursGrup;
import es.limit.cecocloud.rrhh.logic.api.dto.Seccio;

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
						Albara.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_ALTAPL",
				new FuncionalitatCodiFontImpl(
						"FAC_ALTAPL",
						FuncionalitatTipus.MANTENIMENT,
						"Altres aplicacions",
						AltresAplicacions.class,
						Arrays.asList(
								Transportista.class)));
		funcionalitats.put(
				"FAC_APLICA",
				new FuncionalitatCodiFontImpl(
						"FAC_APLICA",
						FuncionalitatTipus.MANTENIMENT,
						"Aplicadors",
						Aplicador.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_APLCLI",
				new FuncionalitatCodiFontImpl(
						"FAC_APLCLI",
						FuncionalitatTipus.MANTENIMENT,
						"Aplicadors-Client",
						AplicadorClient.class,
						Arrays.asList(
								Aplicador.class, 
								Client.class)));
		funcionalitats.put(
				"FAC_ARENEG",
				new FuncionalitatCodiFontImpl(
						"FAC_ARENEG",
						FuncionalitatTipus.MANTENIMENT,
						"Àrea negocis",
						AreaNegoci.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_ARTICL",
				new FuncionalitatCodiFontImpl(
						"FAC_ARTICL",
						FuncionalitatTipus.MANTENIMENT,
						"Articles",
						Article.class,
						Arrays.asList(
								ArticleFamilia.class, 
								Iva.class, 
								ArticleModel.class, 
								ArticleGamma.class, 
								ArticleMarca.class)));
		funcionalitats.put(
				"FAC_FAMART",
				new FuncionalitatCodiFontImpl(
						"FAC_FAMART",
						FuncionalitatTipus.MANTENIMENT,
						"Articles família",
						ArticleFamilia.class,
						Arrays.asList(
								RecursGrup.class, 
								FamiliaCost.class)));
		funcionalitats.put(
				"FAC_EMFART",
				new FuncionalitatCodiFontImpl(
						"FAC_EMFART",
						FuncionalitatTipus.MANTENIMENT,
						"Articles família empresa",
						ArticleFamiliaEmpresa.class,
						Arrays.asList(ArticleFamilia.class)));
		funcionalitats.put(
				"FAC_GAMART",
				new FuncionalitatCodiFontImpl(
						"FAC_GAMART",
						FuncionalitatTipus.MANTENIMENT,
						"Articles gamma",
						ArticleGamma.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_MARART",
				new FuncionalitatCodiFontImpl(
						"FAC_MARART",
						FuncionalitatTipus.MANTENIMENT,
						"Articles marca",
						ArticleMarca.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_MODART",
				new FuncionalitatCodiFontImpl(
						"FAC_MODART",
						FuncionalitatTipus.MANTENIMENT,
						"Articles model",
						ArticleModel.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_AVARIA",
				new FuncionalitatCodiFontImpl(
						"FAC_AVARIA",
						FuncionalitatTipus.MANTENIMENT,
						"Avaries",
						Avaria.class,
						Arrays.asList(
								Empresa.class, 
								es.limit.cecocloud.rrhh.logic.api.dto.Operari.class,
								Pressupost.class, 
								CodiPostal.class, 
								SubClient.class, 
								Client.class, 
								Taller.class, 
								Projecte.class, 
								Albara.class, 
								MantenimentDeTipus.class,
								TipusVenciment.class,
								ClientAdresa.class,
								DocumentPagamentCobrament.class,
								SerieVenda.class)));
		funcionalitats.put(
				"FAC_BANCS",
				new FuncionalitatCodiFontImpl(
						"FAC_BANCS",
						FuncionalitatTipus.MANTENIMENT,
						"Bancs",
						Banc.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_BUSGRO",
				new FuncionalitatCodiFontImpl(
						"FAC_BUSGRO",
						FuncionalitatTipus.MANTENIMENT,
						"Grups d'empreses",
						BusinessGroup.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_CAPITO",
				new FuncionalitatCodiFontImpl(
						"FAC_CAPITO",
						FuncionalitatTipus.MANTENIMENT,
						"Capítols",
						Capitol.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_CLARET",
				new FuncionalitatCodiFontImpl(
						"FAC_CLARET",
						FuncionalitatTipus.MANTENIMENT,
						"Classes de retencions",
						ClasseRetencio.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_CLIENT",
				new FuncionalitatCodiFontImpl(
						"FAC_CLIENT",
						FuncionalitatTipus.MANTENIMENT,
						"Clients",
						Client.class,
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
								TarifaDescompte.class,
								Empresa.class,
								TipusComissio.class,
								PaisNif.class,
								TipusAdresa.class)));
		funcionalitats.put(
				"FAC_ADRCLI",
				new FuncionalitatCodiFontImpl(
						"FAC_ADRCLI",
						FuncionalitatTipus.MANTENIMENT,
						"ClientsAdresa",
						ClientAdresa.class,
						Arrays.asList(
								Client.class, 
								CodiPostal.class, 
								SubClient.class)));
		funcionalitats.put(
				"FAC_CONIMP",
				new FuncionalitatCodiFontImpl(
						"FAC_CONIMP",
						FuncionalitatTipus.MANTENIMENT,
						"Configuracio d'impressos",
						ConfiguracioImpressos.class,
						Arrays.asList(
								Empresa.class, 
								SerieVenda.class)));
		funcionalitats.put(
				"FAC_CP",
				new FuncionalitatCodiFontImpl(
						"FAC_CP",
						FuncionalitatTipus.MANTENIMENT,
						"Codis postals",
						CodiPostal.class,
						Arrays.asList(
								Pais.class, 
								Provincia.class)));
		funcionalitats.put(
				"FAC_EMPCCM",
				new FuncionalitatCodiFontImpl(
						"FAC_EMPCCM",
						FuncionalitatTipus.MANTENIMENT,
						"Comptes comptables empresa",
						CompteComptableEmpresa.class,
						Arrays.asList(Client.class)));
		funcionalitats.put(
				"FAC_EMPCCR",
				new FuncionalitatCodiFontImpl(
						"FAC_EMPCCR",
						FuncionalitatTipus.MANTENIMENT,
						"Comptes corrents empresa",
						CompteCorrentEmpresa.class,
						Arrays.asList(
								Client.class, 
								Banc.class, 
								OficinaBancaria.class)));
		funcionalitats.put(
				"FAC_DEPART",
				new FuncionalitatCodiFontImpl(
						"FAC_DEPART",
						FuncionalitatTipus.MANTENIMENT,
						"Departaments",
						Departament.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_DEPCLI",
				new FuncionalitatCodiFontImpl(
						"FAC_DEPCLI",
						FuncionalitatTipus.MANTENIMENT,
						"DepartamentsClient",
						DepartamentClient.class,
						Arrays.asList(
								Client.class, 
								CodiPostal.class, 
								SubClient.class)));
		funcionalitats.put(
				"FAC_DIVISA",
				new FuncionalitatCodiFontImpl(
						"FAC_DIVISA",
						FuncionalitatTipus.MANTENIMENT,
						"Divises",
						Divisa.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_DOCP-C",
				new FuncionalitatCodiFontImpl(
						"FAC_DOCP-C",
						FuncionalitatTipus.MANTENIMENT,
						"Documents de pagament-cobrament",
						DocumentPagamentCobrament.class,
						Arrays.asList(
								NaturalesaPagamentCobrament.class, 
								Iva.class, 
								RegimIva.class)));
		funcionalitats.put(
				"FAC_EMPRES",
				new FuncionalitatCodiFontImpl(
						"FAC_EMPRES",
						FuncionalitatTipus.MANTENIMENT,
						"Empreses (Facturació)",
						Empresa.class,
						Arrays.asList(
								CodiPostal.class, 
								Divisa.class, 
								Magatzem.class)));
		funcionalitats.put(
				"FAC_EMPGRU",
				new FuncionalitatCodiFontImpl(
						"FAC_EMPGRU",
						FuncionalitatTipus.MANTENIMENT,
						"Empreses del grup",
						EmpresaGrup.class,
						Arrays.asList(
								Group.class,
								Empresa.class)));
		funcionalitats.put(
				"FAC_EMPGRUEMP",
				new FuncionalitatCodiFontImpl(
						"FAC_EMPGRUEMP",
						FuncionalitatTipus.MANTENIMENT,
						"Empreses del grup de empreses",
						EmpresaGrupEmpreses.class,
						Arrays.asList(
								BusinessGroup.class,
								Empresa.class)));
		funcionalitats.put(
				"FAC_ESTPRO",
				new FuncionalitatCodiFontImpl(
						"FAC_ESTPRO",
						FuncionalitatTipus.MANTENIMENT,
						"Estudis projecte",
						EstudiProjecte.class,
						Arrays.asList(
								Divisa.class,
								Projecte.class,
								Empresa.class)));
		funcionalitats.put(
				"FAC_EXPED",
				new FuncionalitatCodiFontImpl(
						"FAC_EXPED",
						FuncionalitatTipus.MANTENIMENT,
						"Expedients",
						Expedient.class,
						Arrays.asList(
								Empresa.class)));
		funcionalitats.put(
				"FAC_FAMCLI",
				new FuncionalitatCodiFontImpl(
						"FAC_FAMCLI",
						FuncionalitatTipus.MANTENIMENT,
						"Famílies client",
						FamiliaClient.class,
						Arrays.asList(TipusRisc.class)));
		funcionalitats.put(
				"FAC_FAMCOS",
				new FuncionalitatCodiFontImpl(
						"FAC_FAMCOS",
						FuncionalitatTipus.MANTENIMENT,
						"Famílies cost",
						FamiliaCost.class,
						Arrays.asList(ArticleFamilia.class)));
		funcionalitats.put(
				"FAC_FAMPRO",
				new FuncionalitatCodiFontImpl(
						"FAC_FAMPRO",
						FuncionalitatTipus.MANTENIMENT,
						"Famílies proveidor",
						FamiliaProveidor.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_FINFAC",
				new FuncionalitatCodiFontImpl(
						"FAC_FINFAC",
						FuncionalitatTipus.MANTENIMENT,
						"Final factures",
						FinalFactura.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_GRO",
				new FuncionalitatCodiFontImpl(
						"FAC_GRO",
						FuncionalitatTipus.MANTENIMENT,
						"Grups",
						Group.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_HISRSP",
				new FuncionalitatCodiFontImpl(
						"FAC_HISRSP",
						FuncionalitatTipus.MANTENIMENT,
						"Històric responsables",
						HistoricResponsable.class,
						Arrays.asList(
								Empresa.class,
								Projecte.class,
								es.limit.cecocloud.rrhh.logic.api.dto.Operari.class)));
		funcionalitats.put(
				"FAC_IDIOMA",
				new FuncionalitatCodiFontImpl(
						"FAC_IDIOMA",
						FuncionalitatTipus.MANTENIMENT,
						"Idiomes",
						Idioma.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_INVSBPS",
				new FuncionalitatCodiFontImpl(
						"FAC_INVSBPS",
						FuncionalitatTipus.MANTENIMENT,
						"Inversions subjectes passius",
						InversioSubjectePassiu.class,
						Arrays.asList(
								Empresa.class,
								Proveidor.class,
								Projecte.class)));
		funcionalitats.put(
				"FAC_IVA",
				new FuncionalitatCodiFontImpl(
						"FAC_IVA",
						FuncionalitatTipus.MANTENIMENT,
						"Iva",
						Iva.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_LINEST",
				new FuncionalitatCodiFontImpl(
						"FAC_LINEST",
						FuncionalitatTipus.MANTENIMENT,
						"Linies estudi",
						LiniaEstudi.class,
						Arrays.asList(
								Empresa.class,
								Projecte.class,
								EstudiProjecte.class)));
		funcionalitats.put(
				"FAC_LIFUFE",
				new FuncionalitatCodiFontImpl(
						"FAC_LIFUFE",
						FuncionalitatTipus.MANTENIMENT,
						"Linies full feina",
						LiniaFullFeina.class,
						Arrays.asList(
								FinalFactura.class)));
		funcionalitats.put(
				"FAC_MAGATZ",
				new FuncionalitatCodiFontImpl(
						"FAC_MAGATZ",
						FuncionalitatTipus.MANTENIMENT,
						"Magatzems",
						Magatzem.class,
						Arrays.asList(
								CodiPostal.class, 
								Divisa.class)));
		funcionalitats.put(
				"FAC_MAGPER",
				new FuncionalitatCodiFontImpl(
						"FAC_MAGPER",
						FuncionalitatTipus.MANTENIMENT,
						"Magatzems període",
						MagatzemPeriode.class,
						Arrays.asList(Magatzem.class)));
		funcionalitats.put(
				"FAC_NATP-C",
				new FuncionalitatCodiFontImpl(
						"FAC_NATP-C",
						FuncionalitatTipus.MANTENIMENT,
						"Naturaleses de pagament/cobrament",
						NaturalesaPagamentCobrament.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_OFIBAN",
				new FuncionalitatCodiFontImpl(
						"FAC_OFIBAN",
						FuncionalitatTipus.MANTENIMENT,
						"Oficines bancaries",
						OficinaBancaria.class,
				Arrays.asList(
								CodiPostal.class, 
								Banc.class)));
		funcionalitats.put(
				"FAC_ORG",
				new FuncionalitatCodiFontImpl(
						"FAC_ORG",
						FuncionalitatTipus.MANTENIMENT,
						"Organitzacions",
						Organitzacio.class,
						Arrays.asList(
								CodiPostal.class)));
		funcionalitats.put(
				"FAC_PAIS",
				new FuncionalitatCodiFontImpl(
						"FAC_PAIS",
						FuncionalitatTipus.MANTENIMENT,
						"Països",
						Pais.class,
						Arrays.asList(),
						Arrays.asList(
								new FuncionalitatCodiFontImpl(
										"FAC_PAIS_ACCIOS",
										FuncionalitatTipus.ACCIO_SIMPLE,
										"Accio simple"),
								new FuncionalitatCodiFontImpl(
										"FAC_PAIS_ACCIOM",
										FuncionalitatTipus.ACCIO_MULTIPLE,
										"Accio múltiple"))));
		funcionalitats.put(
				"FAC_PAINIF",
				new FuncionalitatCodiFontImpl(
					"FAC_PAINIF",
					FuncionalitatTipus.MANTENIMENT,
					"Paisos per Nif",
					PaisNif.class,
					Arrays.asList()));
		funcionalitats.put(
				"FAC_PARAM",
				new FuncionalitatCodiFontImpl(
						"FAC_PARAM",
						FuncionalitatTipus.MANTENIMENT,
						"Parametres",
						Parameter.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_PARTID",
				new FuncionalitatCodiFontImpl(
						"FAC_PARTID",
						FuncionalitatTipus.MANTENIMENT,
						"Partides",
						Partida.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_PEUDOC",
				new FuncionalitatCodiFontImpl(
						"FAC_PEUDOC",
						FuncionalitatTipus.MANTENIMENT,
						"Peus de document",
						PeuDocument.class,
						Arrays.asList(SerieCompra.class)));
		funcionalitats.put(
				"FAC_PRESSU",
				new FuncionalitatCodiFontImpl(
						"FAC_PRESSU",
						FuncionalitatTipus.MANTENIMENT,
						"Pressupostos",
						Pressupost.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_LPR",
				new FuncionalitatCodiFontImpl(
						"FAC_LPR",
						FuncionalitatTipus.MANTENIMENT,
						"Pressupostos Linies",
						PressupostLinia.class,
						Arrays.asList(
								Empresa.class,
								Pressupost.class,
								Article.class)));
		funcionalitats.put(
				"FAC_PREGMA",
				new FuncionalitatCodiFontImpl(
						"FAC_PREGMA",
						FuncionalitatTipus.MANTENIMENT,
						"Preus per gamma",
						PreuPerGamma.class,
						Arrays.asList(
								ArticleGamma.class,
								Transportista.class)));
		funcionalitats.put(
				"FAC_PREZON",
				new FuncionalitatCodiFontImpl(
						"FAC_PREZON",
						FuncionalitatTipus.MANTENIMENT,
						"Preus per zona",
						PreuPerZona.class,
						Arrays.asList(
								Zona.class,
								Transportista.class,
								Divisa.class)));
		funcionalitats.put(
				"FAC_PROD",
				new FuncionalitatCodiFontImpl(
					"FAC_PROD",
					FuncionalitatTipus.MANTENIMENT,
					"Productes",
					Producte.class,
					Arrays.asList(Empresa.class)));
		funcionalitats.put(
				"FAC_PROJEC",
				new FuncionalitatCodiFontImpl(
						"FAC_PROJEC",
						FuncionalitatTipus.MANTENIMENT,
						"Projectes",
						Projecte.class,
						Arrays.asList(
								Divisa.class, 
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
								FinalFactura.class,
								Iva.class,
								RegimIva.class,
								SerieIntracomunitaria.class,
								ProjectePressupost.class,
								ProjecteTarifaProveidor.class,
								ProjecteAplicacio.class,
								InversioSubjectePassiu.class,
								ProveidorVenciment.class,
								HistoricResponsable.class,
								Expedient.class)));
		funcionalitats.put(
				"FAC_PROAAP",
				new FuncionalitatCodiFontImpl(
						"FAC_PROAAP",
						FuncionalitatTipus.MANTENIMENT,
						"Projectes altres aplicacions",
						ProjecteAplicacio.class,
						Arrays.asList(
								Empresa.class,
								Projecte.class)));
		funcionalitats.put(
				"FAC_PROPRE",
				new FuncionalitatCodiFontImpl(
						"FAC_PROPRE",
						FuncionalitatTipus.MANTENIMENT,
						"Projectes / Pressupostos",
						ProjectePressupost.class,
						Arrays.asList(
								Empresa.class,
								Projecte.class,
								Pressupost.class,
								Partida.class,
								Capitol.class)));
		funcionalitats.put(
				"FAC_PROTAJ",
				new FuncionalitatCodiFontImpl(
						"FAC_PROTAJ",
						FuncionalitatTipus.MANTENIMENT,
						"Projectes / Tarifes proveïdors",
						ProjecteTarifaProveidor.class,
						Arrays.asList(
								Empresa.class,
								Projecte.class,
								Proveidor.class,
								TarifaProveidor.class)));
		funcionalitats.put(
				"FAC_PROTIP",
				new FuncionalitatCodiFontImpl(
						"FAC_PROTIP",
						FuncionalitatTipus.MANTENIMENT,
						"Projectes Tipus",
						ProjecteTipus.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_PROVEI",
				new FuncionalitatCodiFontImpl(
						"FAC_PROVEI",
						FuncionalitatTipus.MANTENIMENT,
						"Proveidors",
						Proveidor.class,
						Arrays.asList(
								RegimIva.class,
								CodiPostal.class,
								TipusVenciment.class,
								Divisa.class,
								DocumentPagamentCobrament.class,
								FamiliaProveidor.class)));
		funcionalitats.put(
				"FAC_PROVEN",
				new FuncionalitatCodiFontImpl(
						"FAC_PROVEN",
						FuncionalitatTipus.MANTENIMENT,
						"Venciment per proveïdor",
						ProveidorVenciment.class,
						Arrays.asList(
								Empresa.class,
								Projecte.class,
								Proveidor.class,
								TipusVenciment.class)));
		funcionalitats.put(
				"FAC_PROVIN",
				new FuncionalitatCodiFontImpl(
						"FAC_PROVIN",
						FuncionalitatTipus.MANTENIMENT,
						"Províncies",
						Provincia.class,
						Arrays.asList(Pais.class)));
		funcionalitats.put(
				"FAC_RAPPEL",
				new FuncionalitatCodiFontImpl(
						"FAC_RAPPEL",
						FuncionalitatTipus.MANTENIMENT,
						"Rappels",
						Rappel.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_REGIVA",
				new FuncionalitatCodiFontImpl(
						"FAC_REGIVA",
						FuncionalitatTipus.MANTENIMENT,
						"Règims iva",
						RegimIva.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_REGCOM",
				new FuncionalitatCodiFontImpl(
					"FAC_REGCOM",
					FuncionalitatTipus.MANTENIMENT,
					"Registre comercial",
					RegistreComercial.class,
					Arrays.asList(
							Client.class,
							Producte.class)));
		funcionalitats.put(
				"FAC_SECEMP",
				new FuncionalitatCodiFontImpl(
						"FAC_SECEMP",
						FuncionalitatTipus.MANTENIMENT,
						"Seccions empresa",
						SeccioEmpresa.class,
				Arrays.asList(
								ArticleFamilia.class,
								Seccio.class)));
		funcionalitats.put(
				"FAC_SERCOM",
				new FuncionalitatCodiFontImpl(
						"FAC_SERCOM",
						FuncionalitatTipus.MANTENIMENT,
						"Sèries de compra",
						SerieCompra.class,
						Arrays.asList(
								Magatzem.class,
								Empresa.class)));
		funcionalitats.put(
				"FAC_SERINT",
				new FuncionalitatCodiFontImpl(
						"FAC_SERINT",
						FuncionalitatTipus.MANTENIMENT,
						"Sèries intracomunitàries",
						SerieIntracomunitaria.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_SERVEN",
				new FuncionalitatCodiFontImpl(
						"FAC_SERVEN",
						FuncionalitatTipus.MANTENIMENT,
						"Sèries de venda",
						SerieVenda.class,
						Arrays.asList(
								PeuDocument.class,
								Magatzem.class,
								Departament.class,
								Empresa.class)));
		funcionalitats.put(
				"FAC_SITCOM",
				new FuncionalitatCodiFontImpl(
						"FAC_SITCOM",
						FuncionalitatTipus.MANTENIMENT,
						"Situacions comercials",
						SituacioComercial.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_SITINI",
				new FuncionalitatCodiFontImpl(
						"FAC_SITINI",
						FuncionalitatTipus.MANTENIMENT,
						"Situacions inicials",
						SituacioInicial.class,
						Arrays.asList(
								Magatzem.class,
								Article.class,
								Divisa.class,
								MagatzemPeriode.class)));
		funcionalitats.put(
				"FAC_SUBCLI",
				new FuncionalitatCodiFontImpl(
						"FAC_SUBCLI",
						FuncionalitatTipus.MANTENIMENT,
						"Subclients",
						SubClient.class,
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
								ClientAdresa.class)));
		funcionalitats.put(
				"FAC_SUBVEN",
				new FuncionalitatCodiFontImpl(
						"FAC_SUBVEN",
						FuncionalitatTipus.MANTENIMENT,
						"Subvencions",
						Subvencio.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_TAL",
				new FuncionalitatCodiFontImpl(
						"FAC_TAL",
						FuncionalitatTipus.MANTENIMENT,
						"Tallers",
						Taller.class,
						Arrays.asList(
								Empresa.class,
								Magatzem.class,
								Projecte.class)));
		funcionalitats.put(
				"FAC_TARIFA",
				new FuncionalitatCodiFontImpl(
						"FAC_TARIFA",
						FuncionalitatTipus.MANTENIMENT,
						"Tarifes",
						Tarifa.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_TARPRO",
				new FuncionalitatCodiFontImpl(
						"FAC_TARPRO",
						FuncionalitatTipus.MANTENIMENT,
						"Tarifes proveïdor",
						TarifaProveidor.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_TARDES",
				new FuncionalitatCodiFontImpl(
						"FAC_TARDES",
						FuncionalitatTipus.MANTENIMENT,
						"Tarifes descompte",
						TarifaDescompte.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_TIPADR",
				new FuncionalitatCodiFontImpl(
						"FAC_TIPADR",
						FuncionalitatTipus.MANTENIMENT,
						"Tipus adreça",
						TipusAdresa.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_TIPCLI",
				new FuncionalitatCodiFontImpl(
						"FAC_TIPCLI",
						FuncionalitatTipus.MANTENIMENT,
						"Tipus client",
						TipusClient.class,
						Arrays.asList(
								Client.class,
								TipusProveidorClient.class)));
		funcionalitats.put(
				"FAC_TIPCOM",
				new FuncionalitatCodiFontImpl(
						"FAC_TIPCOM",
						FuncionalitatTipus.MANTENIMENT,
						"Tipus de comissió",
						TipusComissio.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_TIPFAC",
				new FuncionalitatCodiFontImpl(
						"FAC_TIPFAC",
						FuncionalitatTipus.MANTENIMENT,
						"Tipus de facturació",
						TipusFacturacio.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_TIPINF",
				new FuncionalitatCodiFontImpl(
						"FAC_TIPINF",
						FuncionalitatTipus.MANTENIMENT,
						"Tipus incidencia factura",
						TipusIncidenciaFactura.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_TIPP",
				new FuncionalitatCodiFontImpl(
						"FAC_TIPP",
						FuncionalitatTipus.MANTENIMENT,
						"Tipus de proveïdor/client",
						TipusProveidorClient.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_TIPRIS",
				new FuncionalitatCodiFontImpl(
						"FAC_TIPRIS",
						FuncionalitatTipus.MANTENIMENT,
						"Tipus de riscos",
						TipusRisc.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_TIPVEN",
				new FuncionalitatCodiFontImpl(
						"FAC_TIPVEN",
						FuncionalitatTipus.MANTENIMENT,
						"Tipus de venciments",
						TipusVenciment.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_TRANSP",
				new FuncionalitatCodiFontImpl(
						"FAC_TRANSP",
						FuncionalitatTipus.MANTENIMENT,
						"Transportistes",
						Transportista.class,
						Arrays.asList(
								CodiPostal.class,
								Divisa.class,
								Proveidor.class)));
		funcionalitats.put(
				"FAC_UBICAC",
				new FuncionalitatCodiFontImpl(
						"FAC_UBICAC",
						FuncionalitatTipus.MANTENIMENT,
						"Ubicacions",
						Ubicacio.class,
						Arrays.asList(Magatzem.class)));
		funcionalitats.put(
				"FAC_UBIART",
				new FuncionalitatCodiFontImpl(
						"FAC_UBIART",
						FuncionalitatTipus.MANTENIMENT,
						"Ubicacions articles",
						UbicacioArticle.class,
						Arrays.asList(
								Ubicacio.class,
								Article.class,
								Magatzem.class)));
		funcionalitats.put(
				"FAC_UNICONEST",
				new FuncionalitatCodiFontImpl(
						"FAC_UNICONEST",
						FuncionalitatTipus.MANTENIMENT,
						"Unitats control estudi",
						UnitatControlEstudi.class,
						Arrays.asList(
								Empresa.class,
								Projecte.class,
								EstudiProjecte.class)));
		funcionalitats.put(
				"FAC_UNITIP",
				new FuncionalitatCodiFontImpl(
						"FAC_UNITIP",
						FuncionalitatTipus.MANTENIMENT,
						"Unitats tipus",
						UnitatTipus.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_USUGRU",
				new FuncionalitatCodiFontImpl(
						"FAC_USUGRU",
						FuncionalitatTipus.MANTENIMENT,
						"Usuaris del grup",
						UsuariGrup.class,
						Arrays.asList(
								Group.class)));
		funcionalitats.put(
				"FAC_VAD",
				new FuncionalitatCodiFontImpl(
						"FAC_VAD",
						FuncionalitatTipus.MANTENIMENT,
						"Manteniments de tipus",
						MantenimentDeTipus.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_VEHICL",
				new FuncionalitatCodiFontImpl(
						"FAC_VEHICL",
						FuncionalitatTipus.MANTENIMENT,
						"Vehicles",
						Vehicle.class,
						Arrays.asList(Transportista.class)));
		funcionalitats.put(
				"FAC_ZONA",
				new FuncionalitatCodiFontImpl(
						"FAC_ZONA",
						FuncionalitatTipus.MANTENIMENT,
						"Zones",
						Zona.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_CERCLI",
				new FuncionalitatCodiFontImpl(
						"FAC_CERCLI",
						FuncionalitatTipus.MANTENIMENT,
						"Cercador clients",
						Client.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_CERPRJ",
				new FuncionalitatCodiFontImpl(
						"FAC_CERPRJ",
						FuncionalitatTipus.MANTENIMENT,
						"Cercador projectes",
						Projecte.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_CAIXA",
				new FuncionalitatCodiFontImpl(
						"FAC_CAIXA",
						FuncionalitatTipus.MANTENIMENT,
						"Caixes",
						Caixa.class,
						Arrays.asList()));
		funcionalitats.put(
				"FAC_PUNVEN",
				new FuncionalitatCodiFontImpl(
						"FAC_PUNVEN",
						FuncionalitatTipus.MANTENIMENT,
						"Punts de venda",
						PuntVenda.class,
						Arrays.asList(
								Caixa.class,
								Divisa.class,
								Client.class,
								DocumentPagamentCobrament.class,
								Magatzem.class,
								Operari.class,
								SerieVenda.class)));
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