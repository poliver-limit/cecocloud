import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { BngAuthGuard } from 'base-angular';

import { SelectedEmpresaGuard } from '../../shared/selected-empresa.guard';

@NgModule({
	imports: [
		CommonModule,
		RouterModule.forChild([{
			path: '',
			canActivate: [SelectedEmpresaGuard],
			children: [{
				path: '',
				loadChildren: () => import('./pages/index/index-fact.module').then(m => m.IndexFactModule),
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
				path: 'codisPostal',
				loadChildren: () => import('./pages/codisPostal/codisPostal.module').then(m => m.CodisPostalModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'departaments',
				loadChildren: () => import('./pages/departaments/departaments.module').then(m => m.DepartamentsModule),
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
				path: 'familiesCost',
				loadChildren: () => import('./pages/familiesCost/familiesCost.module').then(m => m.FamiliesCostModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'familiesProveidor',
				loadChildren: () => import('./pages/familiesProveidor/familiesProveidor.module').then(m => m.FamiliesProveidorModule),
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
				path: 'paisos',
				loadChildren: () => import('./pages/paisos/paisos.module').then(m => m.PaisosModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'peusDocument',
				loadChildren: () => import('./pages/peusDocument/peusDocument.module').then(m => m.PeusDocumentModule),
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
				path: 'recursosGrup',
				loadChildren: () => import('./pages/recursosGrup/recursosGrup.module').then(m => m.RecursosGrupModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'regimsIva',
				loadChildren: () => import('./pages/regimsIva/regimsIva.module').then(m => m.RegimsIvaModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'seccions',
				loadChildren: () => import('./pages/seccions/seccions.module').then(m => m.SeccionsModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'seccionsEmpresa',
				loadChildren: () => import('./pages/seccionsEmpresa/seccionsEmpresa.module').then(m => m.SeccionsEmpresaModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'seccionsGrup',
				loadChildren: () => import('./pages/seccionsGrup/seccionsGrup.module').then(m => m.SeccionsGrupModule),
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
				path: 'tipusComisions',
				loadChildren: () => import('./pages/tipusComisions/tipusComisions.module').then(m => m.TipusComisionsModule),
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
				path: 'tipusVenciment',
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
export class FactModule {}