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
				loadChildren: './pages/index/index-fact.module#IndexFactModule',
				canActivate: [BngAuthGuard]
	        }, {
				path: 'articles',
				loadChildren: './pages/articles/articles.module#ArticlesModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'articlesFamilia',
				loadChildren: './pages/articlesFamilia/articlesFamilia.module#ArticlesFamiliaModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'articlesFamiliaEmpresa',
				loadChildren: './pages/articlesFamiliaEmpresa/articlesFamiliaEmpresa.module#ArticlesFamiliaEmpresaModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'articlesGamma',
				loadChildren: './pages/articlesGamma/articlesGamma.module#ArticlesGammaModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'articlesMarca',
				loadChildren: './pages/articlesMarca/articlesMarca.module#ArticlesMarcaModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'articlesModel',
				loadChildren: './pages/articlesModel/articlesModel.module#ArticlesModelModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'codisPostal',
				loadChildren: './pages/codisPostal/codisPostal.module#CodisPostalModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'departaments',
				loadChildren: './pages/departaments/departaments.module#DepartamentsModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'divises',
				loadChildren: './pages/divises/divises.module#DivisesModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'documentsPagamentCobrament',
				loadChildren: './pages/documentsPagamentCobrament/documentsPagamentCobrament.module#DocumentsPagamentCobramentModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'empreses',
				loadChildren: './pages/empresesFact/empresesFact.module#EmpresesFactModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'familiesCost',
				loadChildren: './pages/familiesCost/familiesCost.module#FamiliesCostModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'familiesProveidor',
				loadChildren: './pages/familiesProveidor/familiesProveidor.module#FamiliesProveidorModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'ives',
				loadChildren: './pages/ives/ives.module#IvesModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'magatzems',
				loadChildren: './pages/magatzems/magatzems.module#MagatzemsModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'magatzemsPeriode',
				loadChildren: './pages/magatzemsPeriode/magatzemsPeriode.module#MagatzemsPeriodeModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'naturalesesPagamentCobrament',
				loadChildren: './pages/naturalesesPagamentCobrament/naturalesesPagamentCobrament.module#NaturalesesPagamentCobramentModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'paisos',
				loadChildren: './pages/paisos/paisos.module#PaisosModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'peusDocument',
				loadChildren: './pages/peusDocument/peusDocument.module#PeusDocumentModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'proveidors',
				loadChildren: './pages/proveidors/proveidors.module#ProveidorsModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'provincies',
				loadChildren: './pages/provincies/provincies.module#ProvinciesModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'recursosGrup',
				loadChildren: './pages/recursosGrup/recursosGrup.module#RecursosGrupModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'regimsIva',
				loadChildren: './pages/regimsIva/regimsIva.module#RegimsIvaModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'seccions',
				loadChildren: './pages/seccions/seccions.module#SeccionsModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'seccionsEmpresa',
				loadChildren: './pages/seccionsEmpresa/seccionsEmpresa.module#SeccionsEmpresaModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'seccionsGrup',
				loadChildren: './pages/seccionsGrup/seccionsGrup.module#SeccionsGrupModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'seriesCompra',
				loadChildren: './pages/seriesCompra/seriesCompra.module#SeriesCompraModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'seriesIntracomunitaria',
				loadChildren: './pages/seriesIntracomunitaria/seriesIntracomunitaria.module#SeriesIntracomunitariaModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'seriesVenda',
				loadChildren: './pages/seriesVenda/seriesVenda.module#SeriesVendaModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'situacionsComercial',
				loadChildren: './pages/situacionsComercial/situacionsComercial.module#SituacionsComercialModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'situacionsInicial',
				loadChildren: './pages/situacionsInicial/situacionsInicial.module#SituacionsInicialModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'subvencions',
				loadChildren: './pages/subvencions/subvencions.module#SubvencionsModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'tarifes',
				loadChildren: './pages/tarifes/tarifes.module#TarifesModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'tarifesDescompte',
				loadChildren: './pages/tarifesDescompte/tarifesDescompte.module#TarifesDescompteModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'tipusComisions',
				loadChildren: './pages/tipusComisions/tipusComisions.module#TipusComisionsModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'tipusFacturacions',
				loadChildren: './pages/tipusFacturacions/tipusFacturacions.module#TipusFacturacionsModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'tipusIncidenciesFactura',
				loadChildren: './pages/tipusIncidenciesFactura/tipusIncidenciesFactura.module#TipusIncidenciesFacturaModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'tipusProveidorsClient',
				loadChildren: './pages/tipusProveidorsClient/tipusProveidorsClient.module#TipusProveidorsClientModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'tipusRiscos',
				loadChildren: './pages/tipusRiscos/tipusRiscos.module#TipusRiscosModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'tipusVenciment',
				loadChildren: './pages/tipusVenciments/tipusVenciments.module#TipusVencimentsModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'transportistes',
				loadChildren: './pages/transportistes/transportistes.module#TransportistesModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'ubicacions',
				loadChildren: './pages/ubicacions/ubicacions.module#UbicacionsModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'ubicacionsArticle',
				loadChildren: './pages/ubicacionsArticle/ubicacionsArticle.module#UbicacionsArticleModule',
				canActivate: [BngAuthGuard]	
			}, {
				path: 'unitatsTipus',
				loadChildren: './pages/unitatsTipus/unitatsTipus.module#UnitatsTipusModule',
				canActivate: [BngAuthGuard]
			}, {
				path: 'vehicles',
				loadChildren: './pages/vehicles/vehicles.module#VehiclesModule',
				canActivate: [BngAuthGuard]				
			}, {
				path: 'zones',
				loadChildren: './pages/zones/zones.module#ZonesModule',
				canActivate: [BngAuthGuard]
			}, {
				path: '**',
				redirectTo: ''
			}]
		}])
    ]
})
export class FactModule {}