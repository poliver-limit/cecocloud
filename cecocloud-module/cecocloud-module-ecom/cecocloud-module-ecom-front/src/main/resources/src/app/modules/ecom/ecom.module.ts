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
				path: '**',
				redirectTo: ''
			}]
		}])
	]
})
export class FactModule {

	constructor(moduleService: BngModuleService) {
		moduleService.register({
			code: 'ecom',
			icon: 'assignment',
			label: 'eCommerce',
			menuItems: [
				{
					icon: 'dns',
					label: 'Taules generals',
					labelKey: 'funcionalitat.menu.t-generals',
					items: []
				}, {
					icon: 'business',
					label: 'Taules empreses',
					labelKey: 'funcionalitat.menu.t-empreses',
					items: []
				}, {
					icon: 'assignment_returned',
					label: 'Compres',
					labelKey: 'funcionalitat.menu.compres',
					items: []
				}, {
					icon: 'assignment_return',
					label: 'Ventes',
					labelKey: 'funcionalitat.menu.ventes',
					items: []
				}, {
					icon: 'dashboard',
					label: 'Magatzem',
					labelKey: 'funcionalitat.menu.magatzem',
					items: []
				}
			]
		});
	}

}