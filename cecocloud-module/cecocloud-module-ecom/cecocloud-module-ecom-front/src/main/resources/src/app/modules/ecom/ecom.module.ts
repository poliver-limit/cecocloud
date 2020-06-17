import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { BngAuthGuard, BngModuleService } from 'base-angular';

import { SelectedEmpresaGuard } from '../../shared/selected-empresa.guard';

@NgModule({
	imports: [
		CommonModule,
		RouterModule.forChild([{
			path: 'ecom',
			canActivate: [BngAuthGuard, SelectedEmpresaGuard],
			children: [{
				path: '',
				loadChildren: () => import('./pages/index/index-ecom.module').then(m => m.IndexEcomModule)		
				
			}, {
				path: 'albarans',
				loadChildren: () => import('./pages/albarans/albarans.module').then(m => m.AlbaransModule)
				
			}, {
				path: 'albaransLinia',
				loadChildren: () => import('./pages/albaransLinia/albaransLinia.module').then(m => m.AlbaransLiniaModule)
				
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
				path: 'articlesInformacio',
				loadChildren: () => import('./pages/articlesInformacio/articlesInformacio.module').then(m => m.ArticlesInformacioModule)
				
			}, {
				path: 'articlesMarca',
				loadChildren: () => import('./pages/articlesMarca/articlesMarca.module').then(m => m.ArticlesMarcaModule)

			}, {
				path: 'articlesModel',
				loadChildren: () => import('./pages/articlesModel/articlesModel.module').then(m => m.ArticlesModelModule)
				
			}, {
				path: 'articlesTraduccio',
				loadChildren: () => import('./pages/articlesTraduccio/articlesTraduccio.module').then(m => m.ArticlesTraduccioModule)
			
			}, {
				path: 'bestretes',
				loadChildren: () => import('./pages/bestretes/bestretes.module').then(m => m.BestretesModule)
				
			}, {
				path: 'caixes',
				loadChildren: () => import('./pages/caixes/caixes.module').then(m => m.CaixesModule)
				
			}, {
				path: 'caixesMoviment',
				loadChildren: () => import('./pages/caixesMoviment/caixesMoviment.module').then(m => m.CaixesMovimentModule)
				
			}, {
				path: 'clients',
				loadChildren: () => import('./pages/clients/clients.module').then(m => m.ClientsModule)
				
			}, {
				path: 'familiesClient',
				loadChildren: () => import('./pages/familiesClient/familiesClient.module').then(m => m.FamiliesClientModule)
				
			}, {
				path: 'codisPostal',
				loadChildren: () => import('./pages/codisPostal/codisPostal.module').then(m => m.CodisPostalModule)
			}, {
				path: 'departaments',
				loadChildren: () => import('./pages/departaments/departaments.module').then(m => m.DepartamentsModule)
				
			}, {
				path: 'divises',
				loadChildren: () => import('./pages/divises/divises.module').then(m => m.DivisesModule)
				
			}, {
				path: 'documentsPagamentCobrament',
				loadChildren: () => import('./pages/documentsPagamentCobrament/documentsPagamentCobrament.module').then(m => m.DocumentsPagamentCobramentModule)
				
			}, {
				path: 'naturalesesPagamentCobrament',
				loadChildren: () => import('./pages/naturalesesPagamentCobrament/naturalesesPagamentCobrament.module').then(m => m.NaturalesesPagamentCobramentModule)
						
			}, {
				path: 'empreses',
				loadChildren: () => import('./pages/empresesEcom/empresesEcom.module').then(m => m.EmpresesEcomModule)
			
			}, {
				path: 'factures',
				loadChildren: () => import('./pages/factures/factures.module').then(m => m.FacturesModule)
				
			}, {
				path: 'facturesBase',
				loadChildren: () => import('./pages/facturesBase/facturesBase.module').then(m => m.FacturesBaseModule)
				
			}, {
				path: 'familiesProveidor',
				loadChildren: () => import('./pages/familiesProveidor/familiesProveidor.module').then(m => m.FamiliesProveidorModule)
				
			}, {
				path: 'idiomes',
				loadChildren: () => import('./pages/idiomes/idiomes.module').then(m => m.IdiomesModule)			
				
			}, {
				path: 'ives',
				loadChildren: () => import('./pages/ives/ives.module').then(m => m.IvesModule)
				
			}, {
				path: 'regimsIva',
				loadChildren: () => import('./pages/regimsIva/regimsIva.module').then(m => m.RegimsIvaModule)
				
			}, {
				path: 'magatzems',
				loadChildren: () => import('./pages/magatzems/magatzems.module').then(m => m.MagatzemsModule)	
				
			}, {
				path: 'magatzemsArticle',
				loadChildren: () => import('./pages/magatzemsArticle/magatzemsArticle.module').then(m => m.MagatzemsArticleModule)
				
			}, {
				path: 'magatzemsPeriode',
				loadChildren: () => import('./pages/magatzemsPeriode/magatzemsPeriode.module').then(m => m.MagatzemsPeriodeModule)
				
			}, {
				path: 'paisos',
				loadChildren: () => import('./pages/paisos/paisos.module').then(m => m.PaisosModule)					
			
			}, {
				path: 'paisosNif',
				loadChildren: () => import('./pages/paisosNif/paisosNif.module').then(m => m.PaisosNifModule)
					
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
				path: 'proveidors',
				loadChildren: () => import('./pages/proveidors/proveidors.module').then(m => m.ProveidorsModule)
					
			}, {
				path: 'provincies',
				loadChildren: () => import('./pages/provincies/provincies.module').then(m => m.ProvinciesModule)
				
			}, {
				path: 'puntsVenda',
				loadChildren: () => import('./pages/puntsVenda/puntsVenda.module').then(m => m.PuntsVendaModule)
					
			}, {
				path: 'seriesCompra',
				loadChildren: () => import('./pages/seriesCompra/seriesCompra.module').then(m => m.SeriesCompraModule)	
				
			}, {
				path: 'seriesVenda',
				loadChildren: () => import('./pages/seriesVenda/seriesVenda.module').then(m => m.SeriesVendaModule)	
				
			}, {
				path: 'tipusAdreces',
				loadChildren: () => import('./pages/tipusAdreces/tipusAdreces.module').then(m => m.TipusAdrecesModule)	
				
			}, {
				path: 'tipusFacturacions',
				loadChildren: () => import('./pages/tipusFacturacions/tipusFacturacions.module').then(m => m.TipusFacturacionsModule)							
				
			}, {
				path: 'tipusRiscos',
				loadChildren: () => import('./pages/tipusRiscos/tipusRiscos.module').then(m => m.TipusRiscosModule)	
				
			}, {
				path: 'tipusUnitats',
				loadChildren: () => import('./pages/tipusUnitats/tipusUnitats.module').then(m => m.TipusUnitatsModule)	
				
			}, {
				path: 'tipusVenciments',
				loadChildren: () => import('./pages/tipusVenciments/tipusVenciments.module').then(m => m.TipusVencimentsModule)
				
			}, {
				path: 'transportistes',
				loadChildren: () => import('./pages/transportistes/transportistes.module').then(m => m.TransportistesModule)
				
			}, {
				path: 'vehicles',
				loadChildren: () => import('./pages/vehicles/vehicles.module').then(m => m.VehiclesModule)
				
			}, {
				path: 'venciments',
				loadChildren: () => import('./pages/venciments/venciments.module').then(m => m.VencimentsModule)
				
			}, {
				path: 'vencimentsPagat',
				loadChildren: () => import('./pages/vencimentsPagat/vencimentsPagat.module').then(m => m.VencimentsPagatModule)
				
			}, {
				path: '**',
				redirectTo: ''
			}]
		}])
	]
})
export class EcomModule {

	constructor(moduleService: BngModuleService) {
		moduleService.register({
			code: 'ecom',
			icon: 'shopping_cart',
			label: 'eCommerce',
			menuItems: [
				{
					icon: 'shopping_basket',
					label: 'Articles',
					labelKey: 'funcionalitat.menu.articles',
					items: [
						{
							icon: 'room',
							label: 'Articles',
							labelKey: 'app.menu.ecom.articles',
							route: '/ecom/articles',
							resource: 'COM_ARTICL'
						}, {
							icon: 'room',
							label: 'Articles família',
							labelKey: 'app.menu.ecom.articlesFamilia',
							route: '/ecom/articlesFamilia',
							resource: 'COM_FAMART'
//						}, {							
//							icon: 'room',
//							label: 'Articles família empresa',
//							labelKey: 'app.menu.ecom.articlesFamiliaEmpresa',
//							route: '/ecom/articlesFamiliaEmpresa',
//							resource: 'COM_EMFART'
						}, {
							icon: 'room',
							label: 'Articles gamma',
							labelKey: 'app.menu.ecom.articlesGamma',
							route: '/ecom/articlesGamma',
							resource: 'COM_GAMART'
//						}, {
//							icon: 'room',
//							label: 'Articles informació',
//							labelKey: 'app.menu.ecom.articlesInformacio',
//							route: '/ecom/articlesInformacio',
//							resource: 'COM_AINART'
						}, {
							icon: 'room',
							label: 'Articles marca',
							labelKey: 'app.menu.ecom.articlesMarca',
							route: '/ecom/articlesMarca',
							resource: 'COM_MARART'
						}, {
							icon: 'room',
							label: 'Articles model',
							labelKey: 'app.menu.ecom.articlesModel',
							route: '/ecom/articlesModel',
							resource: 'COM_MODART'
//						}, {
//							icon: 'room',
//							label: 'Articles traducció (eCommerce)',
//							labelKey: 'app.menu.ecom.articlesTraduccio',
//							route: '/ecom/articlesTraduccio',
//							resource: 'COM_TRDART'
						}
					]
				}, {						
					icon: 'people',
					label: 'Clients i proveidors',
					labelKey: 'funcionalitat.menu.clients-proveidors',
					items: [
						{
							icon: 'room',
							label: 'Clients (eCommerce)',
							labelKey: 'app.menu.ecom.clients',
							route: '/ecom/clients',
							resource: 'COM_CLI'
						}, {
							icon: 'room',
							label: 'Families client (eCommerce)',
							labelKey: 'app.menu.ecom.familiesClient',
							route: '/ecom/familiesClient',
							resource: 'COM_FMC'
						}, {
							icon: 'room',
							label: 'Proveïdors (eCommerce)',
							labelKey: 'app.menu.ecom.proveidors',
							route: '/ecom/proveidors',
							resource: 'COM_PRO'
						}, {
							icon: 'room',
							label: 'Famílies proveïdor',
							labelKey: 'app.menu.ecom.familiesProveidor',
							route: '/ecom/familiesProveidor',
							resource: 'COM_FPR'
						}, {
							icon: 'room',
							label: 'Transportistes',
							labelKey: 'app.menu.ecom.transportistes',
							route: '/ecom/transportistes',
							resource: 'COM_TRA'
						}, {
							icon: 'room',
							label: 'Vehicles',
							labelKey: 'app.menu.ecom.vehicles',
							route: '/ecom/vehicles',
							resource: 'COM_MTR'
						}, {							
							icon: 'room',
							label: 'Documents pagament/cobrament (eCommerce)',
							labelKey: 'app.menu.ecom.documentsPagamentCobrament',
							route: '/ecom/documentsPagamentCobrament',
							resource: 'COM_DPG'
						}, {							
							icon: 'room',
							label: 'Naturaleses pagament/cobrament (eCommerce)',
							labelKey: 'app.menu.ecom.naturalesesPagamentCobrament',
							route: '/ecom/naturalesesPagamentCobrament',
							resource: 'COM_NPG'
						}
					]
				}, {
					icon: 'headset',
					label: 'Vendes',
					labelKey: 'funcionalitat.menu.ventes',
					items: [
						{							
							icon: 'room',
							label: 'Empreses (eCommerce)',
							labelKey: 'app.menu.ecom.empreses',
							route: '/ecom/empreses',
							resource: 'COM_EMPRES'
						}, {						
							icon: 'room',
							label: 'Iva (eCommerce)',
							labelKey: 'app.menu.ecom.ives',
							route: '/ecom/ives',
							resource: 'COM_IVA'
						}, {						
							icon: 'room',
							label: 'Règims iva (eCommerce)',
							labelKey: 'app.menu.ecom.regimsIva',
							route: '/ecom/regimsIva',
							resource: 'COM_RGI'
						}, {						
							icon: 'room',
							label: 'Magatzems (eCommerce)',
							labelKey: 'app.menu.ecom.magatzems',
							route: '/ecom/magatzems',
							resource: 'COM_MAG'
						}, {						
							icon: 'room',
							label: 'Magatzems-Articles (eCommerce)',
							labelKey: 'app.menu.ecom.magatzemsArticle',
							route: '/ecom/magatzemsArticle',
							resource: 'COM_MAR'
						}, {						
							icon: 'room',
							label: 'Magatzems període (eCommerce)',
							labelKey: 'app.menu.ecom.magatzemsPeriode',
							route: '/ecom/magatzemsPeriode',
							resource: 'COM_PMG'
						}, {						
							icon: 'room',
							label: 'Peus document (eCommerce)',
							labelKey: 'app.menu.ecom.peusDocument',
							route: '/ecom/peusDocument',
							resource: 'COM_PED'
						}, {						
							icon: 'room',
							label: 'Punts de venda (eCommerce)',
							labelKey: 'app.menu.ecom.puntsVenda',
							route: '/ecom/puntsVenda',
							resource: 'COM_PTV'
						}
					]
				}, {
					icon: 'calculate',
					label: 'Facturació',
					labelKey: 'funcionalitat.menu.facturacio',
					items: [
						{									
							icon: 'room',
							label: 'Bestretes (eCommerce)',
							labelKey: 'app.menu.ecom.bestretes',
							route: '/ecom/bestretes',
							resource: 'COM_APC'
						}, {									
							icon: 'room',
							label: 'Caixes (eCommerce)',
							labelKey: 'app.menu.ecom.caixes',
							route: '/ecom/caixes',
							resource: 'COM_CXA'
						}, {									
							icon: 'room',
							label: 'Moviments de caixa (eCommerce)',
							labelKey: 'app.menu.ecom.caixesMoviment',
							route: '/ecom/caixesMoviment',
							resource: 'COM_MDC'
						}, {						
							icon: 'room',
							label: 'Series compra (eCommerce)',
							labelKey: 'app.menu.ecom.seriesCompra',
							route: '/ecom/seriesCompra',
							resource: 'COM_SCP'
						}, {						
							icon: 'room',
							label: 'Series venda (eCommerce)',
							labelKey: 'app.menu.ecom.seriesVenda',
							route: '/ecom/seriesVenda',
							resource: 'COM_SER'
						}, {						
							icon: 'room',
							label: 'Tipus facturacions (eCommerce)',
							labelKey: 'app.menu.ecom.tipusFacturacions',
							route: '/ecom/tipusFacturacions',
							resource: 'COM_TFC'
						}, {						
							icon: 'room',
							label: 'Tipus riscos (eCommerce)',
							labelKey: 'app.menu.ecom.tipusRiscos',
							route: '/ecom/tipusRiscos',
							resource: 'COM_TRI'
						}, {						
							icon: 'room',
							label: 'Tipus unitats (eCommerce)',
							labelKey: 'app.menu.ecom.tipusUnitats',
							route: '/ecom/tipusUnitats',
							resource: 'COM_TUN'
						}, {						
							icon: 'room',
							label: 'Tipus venciments (eCommerce)',
							labelKey: 'app.menu.ecom.tipusVenciments',
							route: '/ecom/tipusVenciments',
							resource: 'COM_TVE'
						}, {						
							icon: 'room',
							label: 'Venciments (eCommerce)',
							labelKey: 'app.menu.ecom.venciments',
							route: '/ecom/venciments',
							resource: 'COM_VEN'
						}, {						
							icon: 'room',
							label: 'Venciments pagats (eCommerce)',
							labelKey: 'app.menu.ecom.vencimentsPagat',
							route: '/ecom/vencimentsPagat',
							resource: 'COM_VCX'
						}
					]
				}, {
					icon: 'notes',
					label: 'Albarans',
					labelKey: 'funcionalitat.menu.albarans',
					items: [
						{						
							icon: 'room',
							label: 'Albarans (eCommerce)',
							labelKey: 'app.menu.ecom.albarans',
							route: '/ecom/albarans',
							resource: 'COM_ALB'
//						}, {						
//							icon: 'room',
//							label: 'Albarans linies (eCommerce)',
//							labelKey: 'app.menu.ecom.albaransLinia',
//							route: '/ecom/albaransLinia',
//							resource: 'COM_LAC'
						}
					]
				}, {
					icon: 'notes',
					label: 'Pressupostos',
					labelKey: 'funcionalitat.menu.pressupostos',
					items: [
						{						
							icon: 'room',
							label: 'Pressupostos (eCommerce)',
							labelKey: 'app.menu.ecom.pressupostos',
							route: '/ecom/pressupostos',
							resource: 'COM_PRE'
//						}, {						
//							icon: 'room',
//							label: 'Pressupostos linies (eCommerce)',
//							labelKey: 'app.menu.ecom.pressupostosLinia',
//							route: '/ecom/pressupostosLinia',
//							resource: 'COM_LPR'
						}
					]
				}, {
					icon: 'notes',
					label: 'Factures',
					labelKey: 'funcionalitat.menu.factures',
					items: [
						{						
							icon: 'room',
							label: 'Factures (eCommerce)',
							labelKey: 'app.menu.ecom.factures',
							route: '/ecom/factures',
							resource: 'COM_FAC'
						}, {						
							icon: 'room',
							label: 'Bases de Factura (eCommerce)',
							labelKey: 'app.menu.ecom.facturesBase',
							route: '/ecom/facturesBase',
							resource: 'COM_BFC'
						}
					]
				}, {
					icon: 'settings_applications',
					label: 'Gestió e-commerce',
					labelKey: 'funcionalitat.menu.gestio-ecommerce',
					items: [
						{
							icon: 'room',
							label: 'Codis postals (eCommerce)',
							labelKey: 'app.menu.ecom.codisPostal',
							route: '/ecom/codisPostal',
							resource: 'COM_CPO'
						}, {
							icon: 'room',
							label: 'Departaments (eCommerce)',
							labelKey: 'app.menu.ecom.departaments',
							route: '/ecom/departaments',
							resource: 'COM_DEP'
						}, {
							icon: 'room',
							label: 'Divises (eCommerce)',
							labelKey: 'app.menu.ecom.divises',
							route: '/ecom/divises',
							resource: 'COM_DIV'
						}, {						
							icon: 'room',
							label: 'Idiomes',
							labelKey: 'app.menu.ecom.idiomes',
							route: '/ecom/idiomes',
							resource: 'COM_IDI'
						}, {						
							icon: 'room',
							label: 'Països (eCommerce)',
							labelKey: 'app.menu.ecom.paisos',
							route: '/ecom/paisos',
							resource: 'COM_PAI'
						}, {						
							icon: 'room',
							label: 'Paisos Nif (eCommerce)',
							labelKey: 'app.menu.ecom.paisosNif',
							route: '/ecom/paisosNif',
							resource: 'COM_PAINIF'
						}, {									
							icon: 'room',
							label: 'Provincies (eCommerce)',
							labelKey: 'app.menu.ecom.provincies',
							route: '/ecom/provincies',
							resource: 'COM_PRV'
						}, {						
							icon: 'room',
							label: 'Tipus adreça (eCommerce)',
							labelKey: 'app.menu.ecom.tipusAdreces',
							route: '/ecom/tipusAdreces',
							resource: 'COM_TIPADR'
						}			
					]
				}
			]
		});
	}

}