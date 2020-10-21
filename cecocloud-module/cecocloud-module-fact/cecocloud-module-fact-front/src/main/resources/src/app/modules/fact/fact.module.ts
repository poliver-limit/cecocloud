import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { BngAuthGuard, BngModuleService } from 'base-angular';

import { SelectedEmpresaGuard } from '../../shared/selected-empresa.guard';

@NgModule({
	imports: [
		CommonModule,
		RouterModule.forChild([{
			path: 'fact',
			canActivate: [BngAuthGuard, SelectedEmpresaGuard],
			children: [{
				path: '',
				loadChildren: () => import('./pages/index/index-fact.module').then(m => m.IndexFactModule)
												   
			}, {
				path: 'cercadorClients',
				loadChildren: () => import('./pages/cercadorClients/cercadorClients.module').then(m => m.CercadorClientsModule)			

			}, {
				path: 'albarans',
				loadChildren: () => import('./pages/albarans/albarans.module').then(m => m.AlbaransModule)

			}, {
				path: 'altresAplicacions',
				loadChildren: () => import('./pages/altresAplicacions/altresAplicacions.module').then(m => m.AltresAplicacionsModule)

			}, {
				path: 'aplicadors',
				loadChildren: () => import('./pages/aplicadors/aplicadors.module').then(m => m.AplicadorsModule)

			}, {
				path: 'aplicadorsClient',
				loadChildren: () => import('./pages/aplicadorsClient/aplicadorsClient.module').then(m => m.AplicadorsClientModule)
			}, {

				path: 'areaNegocis',
				loadChildren: () => import('./pages/areaNegocis/areaNegocis.module').then(m => m.AreaNegocisModule)

			}, {
				path: 'articles',
				loadChildren: () => import('./pages/articles/articles.module').then(m => m.ArticlesModule)

			}, {
				path: 'articlesFamilia',
				loadChildren: () => import('./pages/articlesFamilia/articlesFamilia.module').then(m => m.ArticlesFamiliaModule)

			}, {
				path: 'articlesFamiliaEmpresa',
				loadChildren: () => import('./pages/articlesFamiliaEmpresa/articlesFamiliaEmpresa.module').then(m => m.ArticlesFamiliaEmpresaModule)

			}, {
				path: 'articlesGamma',
				loadChildren: () => import('./pages/articlesGamma/articlesGamma.module').then(m => m.ArticlesGammaModule)

			}, {
				path: 'articlesMarca',
				loadChildren: () => import('./pages/articlesMarca/articlesMarca.module').then(m => m.ArticlesMarcaModule)

			}, {
				path: 'articlesModel',
				loadChildren: () => import('./pages/articlesModel/articlesModel.module').then(m => m.ArticlesModelModule)

			}, {
				path: 'avaries',
				loadChildren: () => import('./pages/avaries/avaries.module').then(m => m.AvariesModule)

			}, {
				path: 'bancs',
				loadChildren: () => import('./pages/bancs/bancs.module').then(m => m.BancsModule)	
				
			}, {
				path: 'businessGroups',
				loadChildren: () => import('./pages/businessGroups/businessGroups.module').then(m => m.BusinessGroupsModule)	
				
			}, {
				path: 'capitols',
				loadChildren: () => import('./pages/capitols/capitols.module').then(m => m.CapitolsModule)		
							
			}, {
				path: 'classesRetencions',
				loadChildren: () => import('./pages/classesRetencions/classesRetencions.module').then(m => m.ClassesRetencionsModule)							   

			}, {
				path: 'comptesComptablesEmpresa',
				loadChildren: () => import('./pages/comptesComptablesEmpresa/comptesComptablesEmpresa.module').then(m => m.ComptesComptablesEmpresaModule)

			}, {
				path: 'comptesCorrentsEmpresa',
				loadChildren: () => import('./pages/comptesCorrentsEmpresa/comptesCorrentsEmpresa.module').then(m => m.ComptesCorrentsEmpresaModule)

			}, {
				path: 'clients',
				loadChildren: () => import('./pages/clients/clients.module').then(m => m.ClientsModule)

			}, {
				path: 'clientsAdresa',
				loadChildren: () => import('./pages/clientsAdresa/clientsAdresa.module').then(m => m.ClientsAdresaModule)

			}, {
				path: 'codisPostal',
				loadChildren: () => import('./pages/codisPostal/codisPostal.module').then(m => m.CodisPostalModule)

			}, {
				path: 'configuracionsImpressos',
				loadChildren: () => import('./pages/configuracionsImpressos/configuracionsImpressos.module').then(m => m.ConfiguracionsImpressosModule)

			}, {
				path: 'departaments',
				loadChildren: () => import('./pages/departaments/departaments.module').then(m => m.DepartamentsModule)

			}, {
				path: 'departamentsClient',
				loadChildren: () => import('./pages/departamentsClient/departamentsClient.module').then(m => m.DepartamentsClientModule)

			}, {
				path: 'divises',
				loadChildren: () => import('./pages/divises/divises.module').then(m => m.DivisesModule)

			}, {
				path: 'documentsPagamentCobrament',
				loadChildren: () => import('./pages/documentsPagamentCobrament/documentsPagamentCobrament.module').then(m => m.DocumentsPagamentCobramentModule)

			}, {
				path: 'empreses',
				loadChildren: () => import('./pages/empresesFact/empresesFact.module').then(m => m.EmpresesFactModule)

			}, {
				path: 'empresesGrup',
				loadChildren: () => import('./pages/empresesGrup/empresesGrup.module').then(m => m.EmpresesGrupModule)

			}, {
				path: 'empresesGrupEmpreses',
				loadChildren: () => import('./pages/empresesGrupEmpreses/empresesGrupEmpreses.module').then(m => m.EmpresesGrupEmpresesModule)

			}, {
				path: 'estudisProjecte',
				loadChildren: () => import('./pages/estudisProjecte/estudisProjecte.module').then(m => m.EstudisProjecteModule)

			}, {
				path: 'familiesClient',
				loadChildren: () => import('./pages/familiesClient/familiesClient.module').then(m => m.FamiliesClientModule)

			}, {
				path: 'familiesCost',
				loadChildren: () => import('./pages/familiesCost/familiesCost.module').then(m => m.FamiliesCostModule)

			}, {
				path: 'familiesProveidor',
				loadChildren: () => import('./pages/familiesProveidor/familiesProveidor.module').then(m => m.FamiliesProveidorModule)

			}, {
				path: 'finalFactures',
				loadChildren: () => import('./pages/finalFactures/finalFactures.module').then(m => m.FinalFacturesModule)
				
			}, {
				path: 'groups',
				loadChildren: () => import('./pages/groups/groups.module').then(m => m.GroupsModule)	
				
			}, {
				path: 'historicsResponsables',
				loadChildren: () => import('./pages/historicsResponsables/historicsResponsables.module').then(m => m.HistoricsResponsablesModule)

			}, {
				path: 'idiomes',
				loadChildren: () => import('./pages/idiomes/idiomes.module').then(m => m.IdiomesModule)

			}, {
				path: 'inversionsSubjectePassiu',
				loadChildren: () => import('./pages/inversionsSubjectePassiu/inversionsSubjectePassiu.module').then(m => m.InversionsSubjectePassiuModule)
				
			}, {
				path: 'ives',
				loadChildren: () => import('./pages/ives/ives.module').then(m => m.IvesModule)

			}, {
				path: 'liniesEstudi',
				loadChildren: () => import('./pages/liniesEstudi/liniesEstudi.module').then(m => m.LiniesEstudiModule)

			}, {
				path: 'liniesFullFeina',
				loadChildren: () => import('./pages/liniesFullFeina/liniesFullFeina.module').then(m => m.LiniesFullFeinaModule)

			}, {
				path: 'magatzems',
				loadChildren: () => import('./pages/magatzems/magatzems.module').then(m => m.MagatzemsModule)

			}, {
				path: 'magatzemsPeriode',
				loadChildren: () => import('./pages/magatzemsPeriode/magatzemsPeriode.module').then(m => m.MagatzemsPeriodeModule)

			}, {
				path: 'naturalesesPagamentCobrament',
				loadChildren: () => import('./pages/naturalesesPagamentCobrament/naturalesesPagamentCobrament.module').then(m => m.NaturalesesPagamentCobramentModule)
			}, {
				path: 'oficinesBancaries',
				loadChildren: () => import('./pages/oficinesBancaries/oficinesBancaries.module').then(m => m.OficinesBancariesModule)	
					
			}, {
				path: 'organitzacions',
				loadChildren: () => import('./pages/organitzacions/organitzacions.module').then(m => m.OrganitzacionsModule)						  

			}, {
				path: 'paisos',
				loadChildren: () => import('./pages/paisos/paisos.module').then(m => m.PaisosModule)

			}, {
				path: 'paisosNif',
				loadChildren: () => import('./pages/paisosNif/paisosNif.module').then(m => m.PaisosNifModule)			   

			}, {
				path: 'partides',
				loadChildren: () => import('./pages/partides/partides.module').then(m => m.PartidesModule)
				
			}, {
				path: 'parameters',
				loadChildren: () => import('./pages/parameters/parameters.module').then(m => m.ParametersModule)

			}, {
				path: 'peusDocument',
				loadChildren: () => import('./pages/peusDocument/peusDocument.module').then(m => m.PeusDocumentModule)
			
			}, {
				path: 'pressupostos',
				loadChildren: () => import('./pages/pressupostos/pressupostos.module').then(m => m.PressupostosModule)

			}, {
				path: 'pressupostosLinia',
				loadChildren: () => import('./pages/pressupostosLinia/pressupostosLinia.module').then(m => m.PressupostosLiniaModule)
					
			}, {
				path: 'preusPerGamma',
				loadChildren: () => import('./pages/preusPerGamma/preusPerGamma.module').then(m => m.PreusPerGammaModule)
				
			}, {
				path: 'preusPerZona',
				loadChildren: () => import('./pages/preusPerZona/preusPerZona.module').then(m => m.PreusPerZonaModule)
				
			}, {
				path: 'productes',
				loadChildren: () => import('./pages/productes/productes.module').then(m => m.ProductesModule)	
					
			}, {
				path: 'cercadorProjectes',
				loadChildren: () => import('./pages/cercadorProjectes/cercadorProjectes.module').then(m => m.CercadorProjectesModule)
				
			}, {
				path: 'projectes',
				loadChildren: () => import('./pages/projectes/projectes.module').then(m => m.ProjectesModule)
				
			}, {
				path: 'projectesAplicacio',
				loadChildren: () => import('./pages/projectesAplicacio/projectesAplicacio.module').then(m => m.ProjectesAplicacioModule)
				
			}, {
				path: 'projectesPressupost',
				loadChildren: () => import('./pages/projectesPressupost/projectesPressupost.module').then(m => m.ProjectesPressupostModule)
				
			}, {
				path: 'projectesTarifaProveidor',
				loadChildren: () => import('./pages/projectesTarifaProveidor/projectesTarifaProveidor.module').then(m => m.ProjectesTarifaProveidorModule)
				
			}, {
				path: 'projectesTipus',
				loadChildren: () => import('./pages/projectesTipus/projectesTipus.module').then(m => m.ProjectesTipusModule)
				
			}, {
				path: 'proveidors',
				loadChildren: () => import('./pages/proveidors/proveidors.module').then(m => m.ProveidorsModule)
				
			}, {
				path: 'proveidorsVenciment',
				loadChildren: () => import('./pages/proveidorsVenciment/proveidorsVenciment.module').then(m => m.ProveidorsVencimentModule)

			}, {
				path: 'provincies',
				loadChildren: () => import('./pages/provincies/provincies.module').then(m => m.ProvinciesModule)

			}, {
				path: 'rappels',
				loadChildren: () => import('./pages/rappels/rappels.module').then(m => m.RappelsModule)

			}, {
				path: 'regimsIva',
				loadChildren: () => import('./pages/regimsIva/regimsIva.module').then(m => m.RegimsIvaModule)

			}, {
				path: 'registresComercials',
				loadChildren: () => import('./pages/registresComercials/registresComercials.module').then(m => m.RegistresComercialsModule)
				
			}, {
				path: 'seccionsEmpresa',
				loadChildren: () => import('./pages/seccionsEmpresa/seccionsEmpresa.module').then(m => m.SeccionsEmpresaModule)

			}, {
				path: 'seriesCompra',
				loadChildren: () => import('./pages/seriesCompra/seriesCompra.module').then(m => m.SeriesCompraModule)

			}, {
				path: 'seriesIntracomunitaria',
				loadChildren: () => import('./pages/seriesIntracomunitaria/seriesIntracomunitaria.module').then(m => m.SeriesIntracomunitariaModule)

			}, {
				path: 'seriesVenda',
				loadChildren: () => import('./pages/seriesVenda/seriesVenda.module').then(m => m.SeriesVendaModule)

			}, {
				path: 'situacionsComercial',
				loadChildren: () => import('./pages/situacionsComercial/situacionsComercial.module').then(m => m.SituacionsComercialModule)

			}, {
				path: 'situacionsInicial',
				loadChildren: () => import('./pages/situacionsInicial/situacionsInicial.module').then(m => m.SituacionsInicialModule)
			}, {
				path: 'subClients',
				loadChildren: () => import('./pages/subClients/subClients.module').then(m => m.SubClientsModule)

			}, {
				path: 'subvencions',
				loadChildren: () => import('./pages/subvencions/subvencions.module').then(m => m.SubvencionsModule)

			}, {
				path: 'tarifes',
				loadChildren: () => import('./pages/tarifes/tarifes.module').then(m => m.TarifesModule)
				
			}, {
				path: 'tarifesProveidor',
				loadChildren: () => import('./pages/tarifesProveidor/tarifesProveidor.module').then(m => m.TarifesProveidorModule)

			}, {
				path: 'tallers',
				loadChildren: () => import('./pages/tallers/tallers.module').then(m => m.TallersModule)
				
			}, {
				path: 'tarifesDescompte',
				loadChildren: () => import('./pages/tarifesDescompte/tarifesDescompte.module').then(m => m.TarifesDescompteModule)

			}, {
				path: 'tipusAdreces',
				loadChildren: () => import('./pages/tipusAdreces/tipusAdreces.module').then(m => m.TipusAdrecesModule)							   

			}, {
				path: 'tipusClients',
				loadChildren: () => import('./pages/tipusClients/tipusClients.module').then(m => m.TipusClientsModule)

			}, {
				path: 'tipusComissions',
				loadChildren: () => import('./pages/tipusComissions/tipusComissions.module').then(m => m.TipusComissionsModule)

			}, {
				path: 'tipusFacturacions',
				loadChildren: () => import('./pages/tipusFacturacions/tipusFacturacions.module').then(m => m.TipusFacturacionsModule)

			}, {
				path: 'tipusIncidenciesFactura',
				loadChildren: () => import('./pages/tipusIncidenciesFactura/tipusIncidenciesFactura.module').then(m => m.TipusIncidenciesFacturaModule)

			}, {
				path: 'tipusProveidorsClient',
				loadChildren: () => import('./pages/tipusProveidorsClient/tipusProveidorsClient.module').then(m => m.TipusProveidorsClientModule)

			}, {
				path: 'tipusRiscos',
				loadChildren: () => import('./pages/tipusRiscos/tipusRiscos.module').then(m => m.TipusRiscosModule)

			}, {
				path: 'tipusVenciments',
				loadChildren: () => import('./pages/tipusVenciments/tipusVenciments.module').then(m => m.TipusVencimentsModule)

			}, {
				path: 'transportistes',
				loadChildren: () => import('./pages/transportistes/transportistes.module').then(m => m.TransportistesModule)

			}, {
				path: 'ubicacions',
				loadChildren: () => import('./pages/ubicacions/ubicacions.module').then(m => m.UbicacionsModule)

			}, {
				path: 'ubicacionsArticle',
				loadChildren: () => import('./pages/ubicacionsArticle/ubicacionsArticle.module').then(m => m.UbicacionsArticleModule)

			}, {
				path: 'unitatsControlEstudi',
				loadChildren: () => import('./pages/unitatsControlEstudi/unitatsControlEstudi.module').then(m => m.UnitatsControlEstudiModule)

			}, {
				path: 'unitatsTipus',
				loadChildren: () => import('./pages/unitatsTipus/unitatsTipus.module').then(m => m.UnitatsTipusModule)

			}, {
				path: 'usuarisGrup',
				loadChildren: () => import('./pages/usuarisGrup/usuarisGrup.module').then(m => m.UsuarisGrupModule)

			}, {
				path: 'mantenimentsDeTipus',
				loadChildren: () => import('./pages/mantenimentsDeTipus/mantenimentsDeTipus.module').then(m => m.MantenimentsDeTipusModule)

			}, {
				path: 'vehicles',
				loadChildren: () => import('./pages/vehicles/vehicles.module').then(m => m.VehiclesModule)

			}, {
				path: 'zones',
				loadChildren: () => import('./pages/zones/zones.module').then(m => m.ZonesModule)

			}, {
				path: '**',
				redirectTo: ''
			}]
		}])
	]
})
export class FactModule {

	constructor(moduleService: BngModuleService) {
		moduleService.register({
			code: 'fact',
			icon: 'assignment',
			label: 'Facturació',
			menuItems: [
				{
					icon: 'dns',
					label: 'Taules generals',
					labelKey: 'funcionalitat.menu.t-generals',
					items: [
						{
							icon: 'layers',
							label: 'Articles',
							labelKey: 'funcionalitat.menu.articles',
							items: [
								{
									icon: 'room',
									label: 'Articles',
									labelKey: 'app.menu.fact.articles',
									route: '/fact/articles',
									resource: 'FAC_ARTICL'
								}, {
									icon: 'room',
									label: 'Articles família',
									labelKey: 'app.menu.fact.articlesFamilia',
									route: '/fact/articlesFamilia',
									resource: 'FAC_FAMART'
								}, {
									icon: 'room',
									label: 'Famílies cost',
									labelKey: 'app.menu.fact.familiesCost',
									route: '/fact/familiesCost',
									resource: 'FAC_FAMCOS'
								}, {
									icon: 'room',
									label: 'Articles família empresa',
									labelKey: 'app.menu.fact.articlesFamiliaEmpresa',
									route: '/fact/articlesFamiliaEmpresa',
									resource: 'FAC_EMFART'
								}, {
									icon: 'room',
									label: 'Articles gamma',
									labelKey: 'app.menu.fact.articlesGamma',
									route: '/fact/articlesGamma',
									resource: 'FAC_GAMART'
								}, {
									icon: 'room',
									label: 'Articles marca',
									labelKey: 'app.menu.fact.articlesMarca',
									route: '/fact/articlesMarca',
									resource: 'FAC_MARART'
								}, {
									icon: 'room',
									label: 'Articles model',
									labelKey: 'app.menu.fact.articlesModel',
									route: '/fact/articlesModel',
									resource: 'FAC_MODART'
								}, {
									icon: 'room',
									label: 'Tipus de comissió',
									labelKey: 'app.menu.fact.tipusComissions',
									route: '/fact/tipusComissions',
									resource: 'FAC_TIPCOM'
								}, {
									icon: 'room',
									label: 'Unitats tipus',
									labelKey: 'app.menu.fact.unitatsTipus',
									route: '/fact/unitatsTipus',
									resource: 'FAC_UNITIP'
								}, {
									icon: 'room',
									label: 'Ubicacions',
									labelKey: 'app.menu.fact.ubicacions',
									route: '/fact/ubicacions',
									resource: 'FAC_UBICAC'
								}, {
									icon: 'room',
									label: 'Ubicacions articles',
									labelKey: 'app.menu.fact.ubicacionsArticle',
									route: '/fact/ubicacionsArticle',
									resource: 'FAC_UBIART'
								}
							]
						}, {
							icon: 'credit_card',
							label: 'Facturacio',
							labelKey: 'funcionalitat.menu.facturacio',
							items: [
								{
									icon: 'room',
									label: 'Tipus de venciments',
									labelKey: 'app.menu.fact.tipusVenciments',
									route: '/fact/tipusVenciments',
									resource: 'FAC_TIPVEN'
								}, {
									icon: 'room',
									label: 'Venciments per proveïdor',
									labelKey: 'app.menu.fact.proveidorsVenciment',
									route: '/fact/proveidorsVenciment',
									resource: 'FAC_PROVEN'
								}, {
									icon: 'room',
									label: 'Règims d\'iva',
									labelKey: 'app.menu.fact.regimsIva',
									route: '/fact/regimsIva',
									resource: 'FAC_REGIVA'
								}, {
									icon: 'room',
									label: 'Iva',
									labelKey: 'app.menu.fact.ives',
									route: '/fact/ives',
									resource: 'FAC_IVA'
								}, {
									icon: 'room',
									label: 'Tipus de facturació',
									labelKey: 'app.menu.fact.tipusFacturacions',
									route: '/fact/tipusFacturacions',
									resource: 'FAC_TIPFAC'
								}, {
									icon: 'room',
									label: 'Tarifes',
									labelKey: 'app.menu.fact.tarifes',
									route: '/fact/tarifes',
									resource: 'FAC_TARIFA'
								}, {
									icon: 'room',
									label: 'Tarifes proveïdor',
									labelKey: 'app.menu.fact.tarifesProveidor',
									route: '/fact/tarifesProveidor',
									resource: 'FAC_TARPRO'
								}, {
									icon: 'room',
									label: 'Tarifes descompte',
									labelKey: 'app.menu.fact.tarifesDescompte',
									route: '/fact/tarifesDescompte',
									resource: 'FAC_TARDES'
								}, {
									icon: 'room',
									label: 'Final factures',
									labelKey: 'app.menu.fact.finalFactures',
									route: '/fact/finalFactures',
									resource: 'FAC_FINFAC'
								},
							]
						}, {
							icon: 'layers',
							label: 'Clients i proveidors',
							labelKey: 'funcionalitat.menu.clients-proveidors',
							items: [
								{
									icon: 'room',
									label: 'Famílies client',
									labelKey: 'app.menu.fact.familiesClient',
									route: '/fact/familiesClient',
									resource: 'FAC_FAMCLI'
								}, {
									icon: 'room',
									label: 'Famílies proveidor',
									labelKey: 'app.menu.fact.familiesProveidor',
									route: '/fact/familiesProveidor',
									resource: 'FAC_FAMPRO'
								}, {
									icon: 'room',
									label: 'Naturaleses de pagament/cobrament',
									labelKey: 'app.menu.fact.naturalesesPagamentCobrament',
									route: '/fact/naturalesesPagamentCobrament',
									resource: 'FAC_NATP-C'
								}, {
									icon: 'room',
									label: 'Documents de pagament/cobrament',
									labelKey: 'app.menu.fact.documentsPagamentCobrament',
									route: '/fact/documentsPagamentCobrament',
									resource: 'FAC_DOCP-C'
								}, {
									icon: 'room',
									label: 'Productes',
									labelKey: 'app.menu.fact.productes',
									route: '/fact/productes',
									resource: 'FAC_PROD'
								}, {
									icon: 'room',
									label: 'Registres comercials',
									labelKey: 'app.menu.fact.registresComercials',
									route: '/fact/registresComercials',
									resource: 'FAC_REGCOM'
//								}, {
//									icon: 'room',
//									label: 'Tipus de client',
//									labelKey: 'app.menu.fact.tipusClients',
//									route: '/fact/tipusClients',
//									resource: 'FAC_TIPCLI'
								}, {
									icon: 'room',
									label: 'Tipus de proveïdor/client',
									labelKey: 'app.menu.fact.tipusProveidorsClient',
									route: '/fact/tipusProveidorsClient',
									resource: 'FAC_TIPP'
								}, {
									icon: 'room',
									label: 'Rappels',
									labelKey: 'app.menu.fact.rappels',
									route: '/fact/rappels',
									resource: 'FAC_RAPPEL'
								}, {
									icon: 'room',
									label: 'Situacions comercials',
									labelKey: 'app.menu.fact.situacionsComercial',
									route: '/fact/situacionsComercial',
									resource: 'FAC_SITCOM'
								}, {
									icon: 'room',
									label: 'Tipus de riscos',
									labelKey: 'app.menu.fact.tipusRiscos',
									route: '/fact/tipusRiscos',
									resource: 'FAC_TIPRIS'								
								}, {
									icon: 'room',
									label: 'Situacions inicials',
									labelKey: 'app.menu.fact.situacionsInicial',
									route: '/fact/situacionsInicial',
									resource: 'FAC_SITINI'
								}, {
									icon: 'room',
									label: 'Tipus d\'incidencia factura',
									labelKey: 'app.menu.fact.tipusIncidenciesFactura',
									route: '/fact/tipusIncidenciesFactura',
									resource: 'FAC_TIPINF'
								}
							]
						}, {
							icon: 'view_agenda',
							label: 'Taules auxiliars',
							labelKey: 'funcionalitat.menu.t-auxiliars',
							items: [
								{
									icon: 'room',
									label: 'Grups d"empreses (pels llistats)',
									labelKey: 'app.menu.fact.businessGroups',
									route: '/fact/businessGroups',
									resource: 'FAC_BUSGRO'
								}, {
									icon: 'room',
									label: 'Altres aplicacions',
									labelKey: 'app.menu.fact.altresAplicacions',
									route: '/fact/altresAplicacions',
									resource: 'FAC_ALTAPL'
								}, {
									icon: 'room',
									label: 'Avaries',
									labelKey: 'app.menu.fact.avaries',
									route: '/fact/avaries',
									resource: 'FAC_AVARIA'
								}, {
									icon: 'room',
									label: 'Configuracions de impressos',
									labelKey: 'app.menu.fact.configuracionsImpressos',
									route: '/fact/configuracionsImpressos',
									resource: 'FAC_CONIMP'
								}, {
									icon: 'room',
									label: 'Empreses (Facturació)',
									labelKey: 'app.menu.fact.empreses',
									route: '/fact/empreses',
									resource: 'FAC_EMPRES'
								}, {
									icon: 'room',
									label: 'Empreses del grup',
									labelKey: 'app.menu.fact.empresesGrup',
									route: '/fact/empresesGrup',
									resource: 'FAC_EMPGRU'
								}, {
									icon: 'room',
									label: 'Estudis projecte',
									labelKey: 'app.menu.fact.estudisProjecte',
									route: '/fact/estudisProjecte',
									resource: 'FAC_ESTPRO'
								}, {
									icon: 'room',
									label: 'Empreses del grup de empreses',
									labelKey: 'app.menu.fact.empresesGrupEmpreses',
									route: '/fact/empresesGrupEmpreses',
									resource: 'FAC_EMPGRUEMP'
								}, {
									icon: 'room',
									label: 'Departaments',
									labelKey: 'app.menu.fact.departaments',
									route: '/fact/departaments',
									resource: 'FAC_DEPART'
								}, {
									icon: 'room',
									label: 'Grups',
									labelKey: 'app.menu.fact.groups',
									route: '/fact/groups',
									resource: 'FAC_GRO'
								}, {
									icon: 'room',
									label: 'Linies estudi',
									labelKey: 'app.menu.fact.liniesEstudi',
									route: '/fact/liniesEstudi',
									resource: 'FAC_LINEST'
								}, {
									icon: 'room',
									label: 'Linies full feina',
									labelKey: 'app.menu.fact.liniesFullFeina',
									route: '/fact/liniesFullFeina',
									resource: 'FAC_LIFUFE'
								}, {
									icon: 'room',
									label: 'Parameters',
									labelKey: 'app.menu.fact.parameters',
									route: '/fact/parameters',
									resource: 'FAC_PARAM'
								}, {
									icon: 'room',
									label: 'Països',
									labelKey: 'app.menu.fact.paisos',
									route: '/fact/paisos',
									resource: 'FAC_PAIS'
								}, {
									icon: 'room',
									label: 'Preus per gamma',
									labelKey: 'app.menu.fact.preusPerGamma',
									route: '/fact/preusPerGamma',
									resource: 'FAC_PREGMA'
								}, {
									icon: 'room',
									label: 'Preus per zona',
									labelKey: 'app.menu.fact.preusPerZona',
									route: '/fact/preusPerZona',
									resource: 'FAC_PREZON'
								}, {
									icon: 'room',
									label: 'Províncies',
									labelKey: 'app.menu.fact.provincies',
									route: '/fact/provincies',
									resource: 'FAC_PROVIN'
								}, {
									icon: 'room',
									label: 'Codis postals',
									labelKey: 'app.menu.fact.codisPostal',
									route: '/fact/codisPostal',
									resource: 'FAC_CP'
								}, {
									icon: 'room',
									label: 'Zones',
									labelKey: 'app.menu.fact.zones',
									route: '/fact/zones',
									resource: 'FAC_ZONA'
								}, {
									icon: 'room',
									label: 'Idiomes',
									labelKey: 'app.menu.fact.idiomes',
									route: '/fact/idiomes',
									resource: 'FAC_IDIOMA'
								}, {
									icon: 'room',
									label: 'Divises',
									labelKey: 'app.menu.fact.divises',
									route: '/fact/divises',
									resource: 'FAC_DIVISA'
								}, {
									icon: 'room',
									label: 'Bancs',
									labelKey: 'app.menu.fact.bancs',
									route: '/fact/bancs',
									resource: 'FAC_BANCS'
								}, {
									icon: 'room',
									label: 'Oficines bancaries',
									labelKey: 'app.menu.fact.oficinesBancaries',
									route: '/fact/oficinesBancaries',
									resource: 'FAC_OFIBAN'
//								}, {
//									icon: 'room',
//									label: 'Comptes corrents empresa',
//									labelKey: 'app.menu.fact.comptesCorrentsEmpresa',
//									route: '/fact/comptesCorrentsEmpresa',
//									resource: 'FAC_EMPCCR'
//								}, {
//									icon: 'room',
//									label: 'Comptes comptables empresa',
//									labelKey: 'app.menu.fact.comptesComptablesEmpresa',
//									route: '/fact/comptesComptablesEmpresa',
//									resource: 'FAC_EMPCCM'
								}, {
									icon: 'room',
									label: 'Tallers',
									labelKey: 'app.menu.fact.tallers',
									route: '/fact/tallers',
									resource: 'FAC_TAL'
								}, {
									icon: 'room',
									label: 'Transportistes',
									labelKey: 'app.menu.fact.transportistes',
									route: '/fact/transportistes',
									resource: 'FAC_TRANSP'
								}, {
									icon: 'room',
									label: 'Unitats control estudi',
									labelKey: 'app.menu.fact.unitatsControlEstudi',
									route: '/fact/unitatsControlEstudi',
									resource: 'FAC_UNICONEST'
								}, {
									icon: 'room',
									label: 'Usuaris del grup',
									labelKey: 'app.menu.fact.usuarisGrup',
									route: '/fact/usuarisGrup',
									resource: 'FAC_USUGRU'
								}, {
									icon: 'room',
									label: 'MantenimentsDeTipus',
									labelKey: 'app.menu.fact.mantenimentsDeTipus',
									route: '/fact/mantenimentsDeTipus',
									resource: 'FAC_VAD'
								}, {
									icon: 'room',
									label: 'Vehicles',
									labelKey: 'app.menu.fact.vehicles',
									route: '/fact/vehicles',
									resource: 'FAC_VEHICL'
								}, {
									icon: 'room',
									label: 'Aplicadors',
									labelKey: 'app.menu.fact.aplicadors',
									route: '/fact/aplicadors',
									resource: 'FAC_APLICA'
								}, {
									icon: 'room',
									label: 'Aplicadors-Client',
									labelKey: 'app.menu.fact.aplicadorsClient',
									route: '/fact/aplicadorsClient',
									resource: 'FAC_APLCLI'
								}
							]
						}
					]
				}, {
					icon: 'business',
					label: 'Taules empreses',
					labelKey: 'funcionalitat.menu.t-empreses',
					items: [
						{
							icon: 'room',
							label: 'Sèries de venda',
							labelKey: 'app.menu.fact.seriesVenda',
							route: '/fact/seriesVenda',
							resource: 'FAC_SERVEN'
						}, {
							icon: 'room',
							label: 'Sèries de compra',
							labelKey: 'app.menu.fact.seriesCompra',
							route: '/fact/seriesCompra',
							resource: 'FAC_SERCOM'
						}, {
							icon: 'room',
							label: 'Sèries intracomunitàries',
							labelKey: 'app.menu.fact.seriesIntracomunitaria',
							route: '/fact/seriesIntracomunitaria',
							resource: 'FAC_SERINT'
						}, {
							icon: 'room',
							label: 'Peus de document',
							labelKey: 'app.menu.fact.peusDocument',
							route: '/fact/peusDocument',
							resource: 'FAC_PEUDOC'
						}, {
							icon: 'room',
							label: 'Àrea negocis',
							labelKey: 'app.menu.fact.areaNegocis',
							route: '/fact/areaNegocis',
							resource: 'FAC_ARENEG'
						}, {
							icon: 'room',
							label: 'Seccions empresa',
							labelKey: 'app.menu.fact.seccionsEmpresa',
							route: '/fact/seccionsEmpresa',
							resource: 'FAC_SECEMP'
						}
					]
				}, {
					icon: 'assignment_returned',
					label: 'Compres',
					labelKey: 'funcionalitat.menu.compres',
					items: [
						{
							icon: 'room',
							label: 'Proveidors',
							labelKey: 'app.menu.fact.proveidors',
							route: '/fact/proveidors',
							resource: 'FAC_PROVEI'
						}
					]
				}, {
					icon: 'assignment_return',
					label: 'Ventes',
					labelKey: 'funcionalitat.menu.ventes',
					items: [
						{
							icon: 'room',
							label: 'Capítols',
							labelKey: 'app.menu.fact.capitols',
							route: '/fact/capitols',
							resource: 'FAC_CAPITO'						
						}, {
							icon: 'room',
							label: 'Clients',
							labelKey: 'app.menu.fact.clients',
							route: '/fact/clients',
							resource: 'FAC_CLIENT'
//						}, {
//							icon: 'room',
//							label: 'ClientsAdresa',
//							labelKey: 'app.menu.fact.clientsAdresa',
//							route: '/fact/clientsAdresa',
//							resource: 'FAC_ADRCLI'
						}, {
							icon: 'room',
							label: 'Partides',
							labelKey: 'app.menu.fact.partides',
							route: '/fact/partides',
							resource: 'FAC_PARTID'
//						}, {
//							icon: 'room',
//							label: 'Subclients',
//							labelKey: 'app.menu.fact.subClients',
//							route: '/fact/subClients',
//							resource: 'FAC_SUBCLI'
						}, {
							icon: 'room',
							label: 'Inversions subjecte passiu',
							labelKey: 'app.menu.fact.inversionsSubjectePassiu',
							route: '/fact/inversionsSubjectePassiu',
							resource: 'FAC_INVSBPS'
							
						}, 	{
							icon: 'room',
							label: 'Cercador projectes',
							labelKey: 'app.menu.fact.cercadorProjectes',
							route: '/fact/cercadorProjectes',
							resource: 'FAC_CERPRJ'
						}, {
							icon: 'room',
							label: 'Històric responsables',
							labelKey: 'app.menu.fact.historicsResponsables',
							route: '/fact/historicsResponsables',
							resource: 'FAC_HISRSP'
						}, {
							icon: 'room',
							label: 'Pressupostos',
							labelKey: 'app.menu.fact.pressupostos',
							route: '/fact/pressupostos',
							resource: 'FAC_PRESSU'
						}, {
							icon: 'room',
							label: 'Projectes',
							labelKey: 'app.menu.fact.projectes',
							route: '/fact/projectes',
							resource: 'FAC_PROJEC'
						}, {
							icon: 'room',
							label: 'Projectes altres aplicacions',
							labelKey: 'app.menu.fact.projectesAplicacio',
							route: '/fact/projectesAplicacio',
							resource: 'FAC_PROAAP'
						}, {
							icon: 'room',
							label: 'Projectes / Pressupostos',
							labelKey: 'app.menu.fact.projectesPressupost',
							route: '/fact/projectesPressupost',
							resource: 'FAC_PROPRE'
						}, {
							icon: 'room',
							label: 'Projectes / Tarifes proveïdor',
							labelKey: 'app.menu.fact.projectesTarifaProveidor',
							route: '/fact/projectesTarifaProveidor',
							resource: 'FAC_PROTAJ'
						}, {
							icon: 'room',
							label: 'Projectes Tipus',
							labelKey: 'app.menu.fact.projectesTipus',
							route: '/fact/projectesTipus',
							resource: 'FAC_PROTIP'
						}, {
							icon: 'room',
							label: 'Albarans',
							labelKey: 'app.menu.fact.albarans',
							route: '/fact/albarans',
							resource: 'FAC_ALBARA'
						}, {
							icon: 'room',
							label: 'Subvencions',
							labelKey: 'app.menu.fact.subvencions',
							route: '/fact/subvencions',
							resource: 'FAC_SUBVEN'
						}, 	{
							icon: 'room',
							label: 'Cercador clients',
							labelKey: 'app.menu.fact.cercadorClients',
							route: '/fact/cercadorClients',
							resource: 'FAC_CERCLI'						
						}, {
							icon: 'room',
							label: 'Classes retencions',
							labelKey: 'app.menu.fact.classesRetencions',
							route: '/fact/classesRetencions',
							resource: 'FAC_CLARET'
						}, {
							icon: 'room',
							label: 'Organitzacions',
							labelKey: 'app.menu.fact.organitzacions',
							route: '/fact/organitzacions',
							resource: 'FAC_ORG'
						}, {
							icon: 'room',
							label: 'Països Nif',
							labelKey: 'app.menu.fact.paisosNif',
							route: '/fact/paisosNif',
							resource: 'FAC_PAINIF'
						}, {
							icon: 'room',
							label: "Tipus d'adreça",
							labelKey: 'app.menu.fact.tipusAdreces',
							route: '/fact/tipusAdreces',
							resource: 'FAC_TIPADR'
						}, {
							icon: 'room',
							label: 'Tipus de comissió',
							labelKey: 'app.menu.fact.tipusComissions',
							route: '/fact/tipusComissions',
							resource: 'FAC_TIPCOM'
						}
					]
				}, {
					icon: 'dashboard',
					label: 'Magatzem',
					labelKey: 'funcionalitat.menu.magatzem',
					items: [
						{
							icon: 'room',
							label: 'Magatzems',
							labelKey: 'app.menu.fact.magatzems',
							route: '/fact/magatzems',
							resource: 'FAC_MAGATZ'
						}, {
							icon: 'room',
							label: 'Magatzems període',
							labelKey: 'app.menu.fact.magatzemsPeriode',
							route: '/fact/magatzemsPeriode',
							resource: 'FAC_MAGPER'
						},
					]
				}
			]
		});
	}

}