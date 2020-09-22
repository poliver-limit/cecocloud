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
			children: [{
				path: 'marcatges',
				loadChildren: () => import('./pages/marcatges/marcatges.module').then(m => m.MarcatgesModule)
			}, {
				path: 'configuracions',
				loadChildren: () => import('./pages/configuracions/configuracions.module').then(m => m.ConfiguracionsModule)
			}, {
				path: 'llocFeina',
				loadChildren: () => import('./pages/llocFeina/llocFeina.module').then(m => m.LlocFeinaModule)
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
				icon: 'settings',
				label: 'Configuració',
				labelKey: 'app.menu.marc.configuracions',
				route: '/marc/configuracions',
				resource: 'MAR_CONFIG'
			}, {
				icon: 'apartment',
				label: 'Configuració',
				labelKey: 'app.menu.marc.llocFeina',
				route: '/marc/llocFeina',
				resource: 'MAR_LLOCFEINA'
			}, {
				icon: 'timer',
				label: 'Marcatges',
				labelKey: 'app.menu.marc.marcatges',
				route: '/marc/marcatges',
				resource: 'MAR_MARCAT'
			}]
		});
	}

}