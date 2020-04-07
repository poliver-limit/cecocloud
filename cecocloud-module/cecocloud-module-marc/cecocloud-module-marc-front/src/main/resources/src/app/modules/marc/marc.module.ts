import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { BngAuthGuard, BngModuleService } from 'base-angular';

import { SelectedEmpresaGuard } from '../../shared/selected-empresa.guard';

@NgModule({
	imports: [
		CommonModule,
		RouterModule.forChild([{
			path: 'marc',
			canActivate: [BngAuthGuard, SelectedEmpresaGuard],
			children: [{/*
				path: '',
				loadChildren: () => import('./pages/index/index-marc.module').then(m => m.IndexMarcModule)
			}, {*/
				path: 'marcatges',
				loadChildren: () => import('./pages/marcatges/marcatges.module').then(m => m.MarcatgesModule)
			}, {
				path: '**',
				redirectTo: 'marcatges'
			}]
		}])
	]
})
export class MarcModule {

	constructor(moduleService: BngModuleService) {
		moduleService.register({
			code: 'marc',
			icon: 'touch_app',
			label: 'Marcatges',
			menuItems: [{
				icon: 'timer',
				label: 'Marcatges',
				labelKey: 'app.menu.marc.marcatges',
				route: '/marc/marcatges',
				resource: 'MAR_MARCAT'
			}/*, {
				icon: 'description',
				label: 'Informe',
				route: '/marc/informe',
				resource: 'MAR_REPORT'
			}*/]
		});
	}

}