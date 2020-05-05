import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { BngAuthGuard, BngModuleService } from 'base-angular';

import { SelectedEmpresaGuard } from '../../shared/selected-empresa.guard';

@NgModule({
	imports: [
		CommonModule,
		RouterModule.forChild([{
			path: 'cites',
			canActivate: [BngAuthGuard, SelectedEmpresaGuard],
			children: [{
				path: 'cites',
				loadChildren: () => import('./pages/cites/cites.module').then(m => m.CitesModule)
			}, {
				path: '**',
				redirectTo: 'cites'
			}]
		}])
	]
})
export class FactModule {

	constructor(moduleService: BngModuleService) {
		moduleService.register({
			code: 'cita',
			icon: 'event',
			label: 'Cites',
			menuItems: [{
				icon: 'event',
				label: 'Cites',
				labelKey: 'app.menu.cita.cites',
				route: '/cita/cites',
				resource: 'CIT_CITA'
			}/*, {
				icon: 'description',
				label: 'Informe',
				route: '/marc/informe',
				resource: 'MAR_REPORT'
			}*/]
		});
	}

}