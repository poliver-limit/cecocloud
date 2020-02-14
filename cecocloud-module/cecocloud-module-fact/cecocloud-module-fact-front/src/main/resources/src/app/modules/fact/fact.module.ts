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
				path: 'albarans',
				loadChildren: () => import('./pages/albarans/albarans.module').then(m => m.AlbaransModule)

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
				path: 'bancs',
				loadChildren: () => import('./pages/bancs/bancs.module').then(m => m.BancsModule)

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
				path: 'idiomes',
				loadChildren: () => import('./pages/idiomes/idiomes.module').then(m => m.IdiomesModule)

			}, {
				path: 'ives',
				loadChildren: () => import('./pages/ives/ives.module').then(m => m.IvesModule)

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
				path: 'paisos',
				loadChildren: () => import('./pages/paisos/paisos.module').then(m => m.PaisosModule)

			}, {
				path: 'peusDocument',
				loadChildren: () => import('./pages/peusDocument/peusDocument.module').then(m => m.PeusDocumentModule)

			}, {
				path: 'projectes',
				loadChildren: () => import('./pages/projectes/projectes.module').then(m => m.ProjectesModule)

			}, {
				path: 'projectesTipus',
				loadChildren: () => import('./pages/projectesTipus/projectesTipus.module').then(m => m.ProjectesTipusModule)

			}, {
				path: 'proveidors',
				loadChildren: () => import('./pages/proveidors/proveidors.module').then(m => m.ProveidorsModule)

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
				path: 'tarifesDescompte',
				loadChildren: () => import('./pages/tarifesDescompte/tarifesDescompte.module').then(m => m.TarifesDescompteModule)

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
				path: 'unitatsTipus',
				loadChildren: () => import('./pages/unitatsTipus/unitatsTipus.module').then(m => m.UnitatsTipusModule)

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
			menuItems: [{
				icon: 'room',
				label: 'Albarans',
				labelKey: 'app.menu.fact.albarans',
				route: '/fact/albarans',
				resource: 'FAC_ALBARA'
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
			}, {
				icon: 'room',
				label: 'Àrea negocis',
				labelKey: 'app.menu.fact.areaNegocis',
				route: '/fact/areaNegocis',
				resource: 'FAC_ARENEG'
			}, {
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
				label: 'Bancs',
				labelKey: 'app.menu.fact.bancs',
				route: '/fact/bancs',
				resource: 'FAC_BANCS'
			}, {
				icon: 'room',
				label: 'Clients',
				labelKey: 'app.menu.fact.clients',
				route: '/fact/clients',
				resource: 'FAC_CLIENT'
			}, {
				icon: 'room',
				label: 'ClientsAdresa',
				labelKey: 'app.menu.fact.clientsAdresa',
				route: '/fact/clientsAdresa',
				resource: 'FAC_ADRCLI'
			}, {
				icon: 'room',
				label: 'Codis postals',
				labelKey: 'app.menu.fact.codisPostal',
				route: '/fact/codisPostal',
				resource: 'FAC_CP'
			}, {
				icon: 'room',
				label: 'Comptes comptables empresa',
				labelKey: 'app.menu.fact.comptesComptablesEmpresa',
				route: '/fact/comptesComptablesEmpresa',
				resource: 'FAC_EMPCCM'
			}, {
				icon: 'room',
				label: 'Comptes corrents empresa',
				labelKey: 'app.menu.fact.comptesCorrentsEmpresa',
				route: '/fact/comptesCorrentsEmpresa',
				resource: 'FAC_EMPCCR'
			}, {
				icon: 'room',
				label: 'Departaments',
				labelKey: 'app.menu.fact.departaments',
				route: '/fact/departaments',
				resource: 'FAC_DEPART'
			}, {
				icon: 'room',
				label: 'DepartamentsClient',
				labelKey: 'app.menu.fact.departamentsClient',
				route: '/fact/departamentsClient',
				resource: 'FAC_DEPCLI'
			}, {
				icon: 'room',
				label: 'Divises',
				labelKey: 'app.menu.fact.divises',
				route: '/fact/divises',
				resource: 'FAC_DIVISA'
			}, {
				icon: 'room',
				label: 'Documents de pagament/cobrament',
				labelKey: 'app.menu.fact.documentsPagamentCobrament',
				route: '/fact/documentsPagamentCobrament',
				resource: 'FAC_DOCP-C'
			}, {
				icon: 'room',
				label: 'Empreses (Facturació)',
				labelKey: 'app.menu.fact.empreses',
				route: '/fact/empreses',
				resource: 'FAC_EMPRES'
			}, {
				icon: 'room',
				label: 'Famílies client',
				labelKey: 'app.menu.fact.familiesClient',
				route: '/fact/familiesClient',
				resource: 'FAC_FAMCLI'
			}, {
				icon: 'room',
				label: 'Famílies cost',
				labelKey: 'app.menu.fact.familiesCost',
				route: '/fact/familiesCost',
				resource: 'FAC_FAMCOS'
			}, {
				icon: 'room',
				label: 'Famílies proveidor',
				labelKey: 'app.menu.fact.familiesProveidor',
				route: '/fact/familiesProveidor',
				resource: 'FAC_FAMPRO'
			}, {
				icon: 'room',
				label: 'Final factures',
				labelKey: 'app.menu.fact.finalFactures',
				route: '/fact/finalFactures',
				resource: 'FAC_FINFAC'
			}, {
				icon: 'room',
				label: 'Idiomes',
				labelKey: 'app.menu.fact.idiomes',
				route: '/fact/idiomes',
				resource: 'FAC_IDIOMA'
			}, {
				icon: 'room',
				label: 'Iva',
				labelKey: 'app.menu.fact.ives',
				route: '/fact/ives',
				resource: 'FAC_IVA'
			}, {
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
			}, {
				icon: 'room',
				label: 'Naturaleses de pagament/cobrament',
				labelKey: 'app.menu.fact.naturalesesPagamentCobrament',
				route: '/fact/naturalesesPagamentCobrament',
				resource: 'FAC_NATP-C'
			}, {
				icon: 'room',
				label: 'Oficines bancaries',
				labelKey: 'app.menu.fact.oficinesBancaries',
				route: '/fact/oficinesBancaries',
				resource: 'FAC_OFIBAN'
			}, {
				icon: 'room',
				label: 'Països',
				labelKey: 'app.menu.fact.paisos',
				route: '/fact/paisos',
				resource: 'FAC_PAIS'
			}, {
				icon: 'room',
				label: 'Peus de document',
				labelKey: 'app.menu.fact.peusDocument',
				route: '/fact/peusDocument',
				resource: 'FAC_PEUDOC'
			}, {
				icon: 'room',
				label: 'Projectes',
				labelKey: 'app.menu.fact.projectes',
				route: '/fact/projectes',
				resource: 'FAC_PROJEC'
			}, {
				icon: 'room',
				label: 'Projectes Tipus',
				labelKey: 'app.menu.fact.projectesTipus',
				route: '/fact/projectesTipus',
				resource: 'FAC_PROTIP'
			}, {
				icon: 'room',
				label: 'Proveidors',
				labelKey: 'app.menu.fact.proveidors',
				route: '/fact/proveidors',
				resource: 'FAC_PROVEI'
			}, {
				icon: 'room',
				label: 'Províncies',
				labelKey: 'app.menu.fact.provincies',
				route: '/fact/provincies',
				resource: 'FAC_PROVIN'
			}, {
				icon: 'room',
				label: 'Rappels',
				labelKey: 'app.menu.fact.rappels',
				route: '/fact/rappels',
				resource: 'FAC_RAPPEL'
			}, {
				icon: 'room',
				label: 'Règims d\'iva',
				labelKey: 'app.menu.fact.regimsIva',
				route: '/fact/regimsIva',
				resource: 'FAC_REGIVA'
			}, {
				icon: 'room',
				label: 'Seccions empresa',
				labelKey: 'app.menu.fact.seccionsEmpresa',
				route: '/fact/seccionsEmpresa',
				resource: 'FAC_SECEMP'
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
				label: 'Sèries de venda',
				labelKey: 'app.menu.fact.seriesVenda',
				route: '/fact/seriesVenda',
				resource: 'FAC_SERVEN'
			}, {
				icon: 'room',
				label: 'Situacions comercials',
				labelKey: 'app.menu.fact.situacionsComercial',
				route: '/fact/situacionsComercial',
				resource: 'FAC_SITCOM'
			}, {
				icon: 'room',
				label: 'Situacions inicials',
				labelKey: 'app.menu.fact.situacionsInicial',
				route: '/fact/situacionsInicial',
				resource: 'FAC_SITINI'
			}, {
				icon: 'room',
				label: 'Subclients',
				labelKey: 'app.menu.fact.subClients',
				route: '/fact/subClients',
				resource: 'FAC_SUBCLI'
			}, {
				icon: 'room',
				label: 'Subvencions',
				labelKey: 'app.menu.fact.subvencions',
				route: '/fact/subvencions',
				resource: 'FAC_SUBVEN'
			}, {
				icon: 'room',
				label: 'Tarifes',
				labelKey: 'app.menu.fact.tarifes',
				route: '/fact/tarifes',
				resource: 'FAC_TARIFA'
			}, {
				icon: 'room',
				label: 'Tarifes descompte',
				labelKey: 'app.menu.fact.tarifesDescompte',
				route: '/fact/tarifesDescompte',
				resource: 'FAC_TARDES'
			}, {
				icon: 'room',
				label: 'Tipus de comissió',
				labelKey: 'app.menu.fact.tipusComissions',
				route: '/fact/tipusComissions',
				resource: 'FAC_TIPCOM'
			}, {
				icon: 'room',
				label: 'Tipus de facturació',
				labelKey: 'app.menu.fact.tipusFacturacions',
				route: '/fact/tipusFacturacions',
				resource: 'FAC_TIPFAC'
			}, {
				icon: 'room',
				label: 'Tipus d\'incidencia factura',
				labelKey: 'app.menu.fact.tipusIncidenciesFactura',
				route: '/fact/tipusIncidenciesFactura',
				resource: 'FAC_TIPINF'
			}, {
				icon: 'room',
				label: 'Tipus de proveïdor/client',
				labelKey: 'app.menu.fact.tipusProveidorsClient',
				route: '/fact/tipusProveidorsClient',
				resource: 'FAC_TIPP-C'
			}, {
				icon: 'room',
				label: 'Tipus de riscos',
				labelKey: 'app.menu.fact.tipusRiscos',
				route: '/fact/tipusRiscos',
				resource: 'FAC_TIPRIS'
			}, {
				icon: 'room',
				label: 'Tipus de venciments',
				labelKey: 'app.menu.fact.tipusVenciments',
				route: '/fact/tipusVenciments',
				resource: 'FAC_TIPVEN'
			}, {
				icon: 'room',
				label: 'Transportistes',
				labelKey: 'app.menu.fact.transportistes',
				route: '/fact/transportistes',
				resource: 'FAC_TRANSP'
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
			}, {
				icon: 'room',
				label: 'Unitats tipus',
				labelKey: 'app.menu.fact.unitatsTipus',
				route: '/fact/unitatsTipus',
				resource: 'FAC_UNITIP'
			}, {
				icon: 'room',
				label: 'Vehicles',
				labelKey: 'app.menu.fact.vehicles',
				route: '/fact/vehicles',
				resource: 'FAC_VEHICL'
			}, {
				icon: 'room',
				label: 'Zones',
				labelKey: 'app.menu.fact.zones',
				route: '/fact/zones',
				resource: 'FAC_ZONA'
			}]
		});
	}

}