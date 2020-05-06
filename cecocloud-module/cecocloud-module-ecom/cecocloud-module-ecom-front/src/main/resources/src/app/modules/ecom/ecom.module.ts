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
				path: 'empreses',
				loadChildren: () => import('./pages/empresesEcom/empresesEcom.module').then(m => m.EmpresesEcomModule)
				
			}, {
				path: 'ives',
				loadChildren: () => import('./pages/ives/ives.module').then(m => m.IvesModule)				
			
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
					icon: 'dns',
					label: 'Taules generals',
					labelKey: 'funcionalitat.menu.t-generals',
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
						}, {							
							icon: 'room',
							label: 'Articles família empresa',
							labelKey: 'app.menu.ecom.articlesFamiliaEmpresa',
							route: '/ecom/articlesFamiliaEmpresa',
							resource: 'COM_EMFART'
						}, {
							icon: 'room',
							label: 'Articles gamma',
							labelKey: 'app.menu.ecom.articlesGamma',
							route: '/ecom/articlesGamma',
							resource: 'COM_GAMART'
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
						}, {							
							icon: 'room',
							label: 'Empreses (eCommerce)',
							labelKey: 'app.menu.ecom.empreses',
							route: '/ecom/empreses',
							resource: 'COM_EMPRES'
						}, {						
							icon: 'room',
							label: 'Iva',
							labelKey: 'app.menu.ecom.ives',
							route: '/ecom/ives',
							resource: 'COM_IVA'
						}						
					]
				}
			]
		});
	}

}