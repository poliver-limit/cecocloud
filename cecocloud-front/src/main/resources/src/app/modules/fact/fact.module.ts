import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { BngAuthGuard, BngModuleService } from 'base-angular';

import { SelectedEmpresaGuard } from '../../shared/selector-empresa/selected-empresa.guard';

@NgModule({
	imports: [
		CommonModule,
		RouterModule.forChild([{
			path: 'fact',
			canActivate: [SelectedEmpresaGuard],
			children: [{
				path: '',
				loadChildren: () => import('./pages/index/index-fact.module').then(m => m.IndexFactModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'albarans',
				loadChildren: () => import('./pages/albarans/albarans.module').then(m => m.AlbaransModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'aplicadors',
				loadChildren: () => import('./pages/aplicadors/aplicadors.module').then(m => m.AplicadorsModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'aplicadorsClient',
				loadChildren: () => import('./pages/aplicadorsClient/aplicadorsClient.module').then(m => m.AplicadorsClientModule),
				canActivate: [BngAuthGuard]
	        },{
				path: 'areaNegocis',
				loadChildren: () => import('./pages/areaNegocis/areaNegocis.module').then(m => m.AreaNegocisModule),
				canActivate: [BngAuthGuard]
	        }, {
				path: 'articles',
				loadChildren: () => import('./pages/articles/articles.module').then(m => m.ArticlesModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'articlesFamilia',
				loadChildren: () => import('./pages/articlesFamilia/articlesFamilia.module').then(m => m.ArticlesFamiliaModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'articlesFamiliaEmpresa',
				loadChildren: () => import('./pages/articlesFamiliaEmpresa/articlesFamiliaEmpresa.module').then(m => m.ArticlesFamiliaEmpresaModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'articlesGamma',
				loadChildren: () => import('./pages/articlesGamma/articlesGamma.module').then(m => m.ArticlesGammaModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'articlesMarca',
				loadChildren: () => import('./pages/articlesMarca/articlesMarca.module').then(m => m.ArticlesMarcaModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'articlesModel',
				loadChildren: () => import('./pages/articlesModel/articlesModel.module').then(m => m.ArticlesModelModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'bancs',
				loadChildren: () => import('./pages/bancs/bancs.module').then(m => m.BancsModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'comptesComptablesEmpresa',
				loadChildren: () => import('./pages/comptesComptablesEmpresa/comptesComptablesEmpresa.module').then(m => m.ComptesComptablesEmpresaModule),
				canActivate: [BngAuthGuard]	
			}, {
				path: 'comptesCorrentsEmpresa',
				loadChildren: () => import('./pages/comptesCorrentsEmpresa/comptesCorrentsEmpresa.module').then(m => m.ComptesCorrentsEmpresaModule),
				canActivate: [BngAuthGuard]	
			}, {
				path: 'clients',
				loadChildren: () => import('./pages/clients/clients.module').then(m => m.ClientsModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'clientsAdresa',
				loadChildren: () => import('./pages/clientsAdresa/clientsAdresa.module').then(m => m.ClientsAdresaModule),
				canActivate: [BngAuthGuard]					
			}, {
				path: 'codisPostal',
				loadChildren: () => import('./pages/codisPostal/codisPostal.module').then(m => m.CodisPostalModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'departaments',
				loadChildren: () => import('./pages/departaments/departaments.module').then(m => m.DepartamentsModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'departamentsClient',
				loadChildren: () => import('./pages/departamentsClient/departamentsClient.module').then(m => m.DepartamentsClientModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'divises',
				loadChildren: () => import('./pages/divises/divises.module').then(m => m.DivisesModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'documentsPagamentCobrament',
				loadChildren: () => import('./pages/documentsPagamentCobrament/documentsPagamentCobrament.module').then(m => m.DocumentsPagamentCobramentModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'empreses',
				loadChildren: () => import('./pages/empresesFact/empresesFact.module').then(m => m.EmpresesFactModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'familiesClient',
				loadChildren: () => import('./pages/familiesClient/familiesClient.module').then(m => m.FamiliesClientModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'familiesCost',
				loadChildren: () => import('./pages/familiesCost/familiesCost.module').then(m => m.FamiliesCostModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'familiesProveidor',
				loadChildren: () => import('./pages/familiesProveidor/familiesProveidor.module').then(m => m.FamiliesProveidorModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'finalFactures',
				loadChildren: () => import('./pages/finalFactures/finalFactures.module').then(m => m.FinalFacturesModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'idiomes',
				loadChildren: () => import('./pages/idiomes/idiomes.module').then(m => m.IdiomesModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'ives',
				loadChildren: () => import('./pages/ives/ives.module').then(m => m.IvesModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'magatzems',
				loadChildren: () => import('./pages/magatzems/magatzems.module').then(m => m.MagatzemsModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'magatzemsPeriode',
				loadChildren: () => import('./pages/magatzemsPeriode/magatzemsPeriode.module').then(m => m.MagatzemsPeriodeModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'naturalesesPagamentCobrament',
				loadChildren: () => import('./pages/naturalesesPagamentCobrament/naturalesesPagamentCobrament.module').then(m => m.NaturalesesPagamentCobramentModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'oficinesBancaries',
				loadChildren: () => import('./pages/oficinesBancaries/oficinesBancaries.module').then(m => m.OficinesBancariesModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'paisos',
				loadChildren: () => import('./pages/paisos/paisos.module').then(m => m.PaisosModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'peusDocument',
				loadChildren: () => import('./pages/peusDocument/peusDocument.module').then(m => m.PeusDocumentModule),
				canActivate: [BngAuthGuard]
			},{
				path: 'projectes',
				loadChildren: () => import('./pages/projectes/projectes.module').then(m => m.ProjectesModule),
				canActivate: [BngAuthGuard]
			},{
				path: 'projectesTipus',
				loadChildren: () => import('./pages/projectesTipus/projectesTipus.module').then(m => m.ProjectesTipusModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'proveidors',
				loadChildren: () => import('./pages/proveidors/proveidors.module').then(m => m.ProveidorsModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'provincies',
				loadChildren: () => import('./pages/provincies/provincies.module').then(m => m.ProvinciesModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'rappels',
				loadChildren: () => import('./pages/rappels/rappels.module').then(m => m.RappelsModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'regimsIva',
				loadChildren: () => import('./pages/regimsIva/regimsIva.module').then(m => m.RegimsIvaModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'seccionsEmpresa',
				loadChildren: () => import('./pages/seccionsEmpresa/seccionsEmpresa.module').then(m => m.SeccionsEmpresaModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'seriesCompra',
				loadChildren: () => import('./pages/seriesCompra/seriesCompra.module').then(m => m.SeriesCompraModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'seriesIntracomunitaria',
				loadChildren: () => import('./pages/seriesIntracomunitaria/seriesIntracomunitaria.module').then(m => m.SeriesIntracomunitariaModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'seriesVenda',
				loadChildren: () => import('./pages/seriesVenda/seriesVenda.module').then(m => m.SeriesVendaModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'situacionsComercial',
				loadChildren: () => import('./pages/situacionsComercial/situacionsComercial.module').then(m => m.SituacionsComercialModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'situacionsInicial',
				loadChildren: () => import('./pages/situacionsInicial/situacionsInicial.module').then(m => m.SituacionsInicialModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'subClients',
				loadChildren: () => import('./pages/subClients/subClients.module').then(m => m.SubClientsModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'subvencions',
				loadChildren: () => import('./pages/subvencions/subvencions.module').then(m => m.SubvencionsModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'tarifes',
				loadChildren: () => import('./pages/tarifes/tarifes.module').then(m => m.TarifesModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'tarifesDescompte',
				loadChildren: () => import('./pages/tarifesDescompte/tarifesDescompte.module').then(m => m.TarifesDescompteModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'tipusClients',
				loadChildren: () => import('./pages/tipusClients/tipusClients.module').then(m => m.TipusClientsModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'tipusComissions',
				loadChildren: () => import('./pages/tipusComissions/tipusComissions.module').then(m => m.TipusComissionsModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'tipusFacturacions',
				loadChildren: () => import('./pages/tipusFacturacions/tipusFacturacions.module').then(m => m.TipusFacturacionsModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'tipusIncidenciesFactura',
				loadChildren: () => import('./pages/tipusIncidenciesFactura/tipusIncidenciesFactura.module').then(m => m.TipusIncidenciesFacturaModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'tipusProveidorsClient',
				loadChildren: () => import('./pages/tipusProveidorsClient/tipusProveidorsClient.module').then(m => m.TipusProveidorsClientModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'tipusRiscos',
				loadChildren: () => import('./pages/tipusRiscos/tipusRiscos.module').then(m => m.TipusRiscosModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'tipusVenciments',
				loadChildren: () => import('./pages/tipusVenciments/tipusVenciments.module').then(m => m.TipusVencimentsModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'transportistes',
				loadChildren: () => import('./pages/transportistes/transportistes.module').then(m => m.TransportistesModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'ubicacions',
				loadChildren: () => import('./pages/ubicacions/ubicacions.module').then(m => m.UbicacionsModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'ubicacionsArticle',
				loadChildren: () => import('./pages/ubicacionsArticle/ubicacionsArticle.module').then(m => m.UbicacionsArticleModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'unitatsTipus',
				loadChildren: () => import('./pages/unitatsTipus/unitatsTipus.module').then(m => m.UnitatsTipusModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'vehicles',
				loadChildren: () => import('./pages/vehicles/vehicles.module').then(m => m.VehiclesModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'zones',
				loadChildren: () => import('./pages/zones/zones.module').then(m => m.ZonesModule),
				canActivate: [BngAuthGuard]
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
				{ icon: 'room', label: 'Albarans', route: '/fact/albarans' },
				{ icon: 'room', label: 'Aplicadors', route: '/fact/aplicadors' },
				{ icon: 'room', label: 'Aplicadors-Client', route: '/fact/aplicadorsClient' },
				{ icon: 'room', label: 'Articles', route: '/fact/articles' },
				{ icon: 'room', label: 'Articles família', route: '/fact/articlesFamilia' },
				{ icon: 'room', label: 'Articles família empresa', route: '/fact/articlesFamiliaEmpresa' },
				{ icon: 'room', label: 'Articles gamma', route: '/fact/articlesGamma' },
				{ icon: 'room', label: 'Articles marca', route: '/fact/articlesMarca' },
				{ icon: 'room', label: 'Articles model', route: '/fact/articlesModel' },
				{ icon: 'room', label: 'Bancs', route: '/fact/bancs' },
				{ icon: 'room', label: 'Clients', route: '/fact/clients' },
				{ icon: 'room', label: 'ClientsAdresa', route: '/fact/clientsAdresa' },
				{ icon: 'room', label: 'Codis postals', route: '/fact/codisPostal' },
				{ icon: 'room', label: 'Comptes comptables empresa', route: '/fact/comptesComptablesEmpresa' },
				{ icon: 'room', label: 'Comptes corrents empresa', route: '/fact/comptesCorrentsEmpresa' },
				{ icon: 'room', label: 'Departaments', route: '/fact/departaments' },
				{ icon: 'room', label: 'DepartamentsClient', route: '/fact/departamentsClient' },
				{ icon: 'room', label: 'Divises', route: '/fact/divises' },
				{ icon: 'room', label: 'Documents de pagament/cobrament', route: '/fact/documentsPagamentCobrament' },
				{ icon: 'room', label: 'Empreses (Facturació)', route: '/fact/empreses' },
				{ icon: 'room', label: 'Famílies client', route: '/fact/familiesClient' },
				{ icon: 'room', label: 'Famílies cost', route: '/fact/familiesCost' },
				{ icon: 'room', label: 'Famílies proveidor', route: '/fact/familiesProveidor' },
				{ icon: 'room', label: 'Idiomes', route: '/fact/idiomes' },
				{ icon: 'room', label: 'Iva', route: '/fact/ives' },
				{ icon: 'room', label: 'Magatzems', route: '/fact/magatzems' },
				{ icon: 'room', label: 'Magatzems període', route: '/fact/magatzemsPeriode' },
				{ icon: 'room', label: 'Naturaleses de pagament/cobrament', route: '/fact/naturalesesPagamentCobrament' },
				{ icon: 'room', label: 'Oficines bancaries', route: '/fact/oficinesBancaries' },
				{ icon: 'room', label: 'Països', route: '/fact/paisos' },
				{ icon: 'room', label: 'Peus de document', route: '/fact/peusDocument' },
				{ icon: 'room', label: 'Projectes', route: '/fact/projectes' },
				{ icon: 'room', label: 'Proveidors', route: '/fact/proveidors' },
				{ icon: 'room', label: 'Províncies', route: '/fact/provincies' },
				{ icon: 'room', label: 'Rappels', route: '/fact/rappels' },
				{ icon: 'room', label: 'Règims d\'iva', route: '/fact/regimsIva' },
				{ icon: 'room', label: 'Seccions empresa', route: '/fact/seccionsEmpresa' },
				{ icon: 'room', label: 'Sèries de compra', route: '/fact/seriesCompra' },
				{ icon: 'room', label: 'Sèries intracomunitàries', route: '/fact/seriesIntracomunitaria' },
				{ icon: 'room', label: 'Sèries de venda', route: '/fact/seriesVenda' },
				{ icon: 'room', label: 'Situacions comercials', route: '/fact/situacionsComercial' },
				{ icon: 'room', label: 'Situacions inicials', route: '/fact/situacionsInicial' },
				{ icon: 'room', label: 'Subclients', route: '/fact/subClients' },
				{ icon: 'room', label: 'Subvencions', route: '/fact/subvencions' },
				{ icon: 'room', label: 'Tarifes', route: '/fact/tarifes' },
				{ icon: 'room', label: 'Tarifes descompte', route: '/fact/tarifesDescompte' },
				{ icon: 'room', label: 'Tipus de client', route: '/fact/tipusClients' },
				{ icon: 'room', label: 'Tipus de comissió', route: '/fact/tipusComissions' },
				{ icon: 'room', label: 'Tipus de facturació', route: '/fact/tipusFacturacions' },
				{ icon: 'room', label: 'Tipus d\'incidencia factura', route: '/fact/tipusIncidenciesFactura' },
				{ icon: 'room', label: 'Tipus de proveïdor/client', route: '/fact/tipusProveidorsClient' },
				{ icon: 'room', label: 'Tipus de riscos', route: '/fact/tipusRiscos' },
				{ icon: 'room', label: 'Tipus de venciments', route: '/fact/tipusVenciments' },
				{ icon: 'room', label: 'Transportistes', route: '/fact/transportistes' },
				{ icon: 'room', label: 'Ubicacions', route: '/fact/ubicacions' },
				{ icon: 'room', label: 'Ubicacions articles', route: '/fact/ubicacionsArticle' },
				{ icon: 'room', label: 'Unitats tipus', route: '/fact/unitatsTipus' },
				{ icon: 'room', label: 'Vehicles', route: '/fact/vehicles' },
				{ icon: 'room', label: 'Zones (Facturació)', route: '/fact/zones' }
			]
		});
	}

}