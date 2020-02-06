import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { BngAuthGuard, BngModuleService } from 'base-angular';

import { SelectedEmpresaGuard } from '../../shared/selected-empresa.guard';

@NgModule({
	imports: [
		CommonModule,
		RouterModule.forChild([{
			path: 'lici',
			canActivate: [BngAuthGuard, SelectedEmpresaGuard],
			children: [{
				path: '',
				loadChildren: () => import('./pages/index/index-lici.module').then(m => m.IndexLiciModule)
			}, {
				path: '**',
				redirectTo: ''
			}]
		}])
	]
})
export class LiciModule {

	constructor(moduleService: BngModuleService) {
		moduleService.register({
			code: 'lici',
			icon: 'folder_special',
			label: 'Licitacions',
			/*menuItems: [{
				icon: 'timer',
				label: 'Marcatges',
				labelKey: 'app.menu.marc.marcatges',
				route: '/marc/marcatges'
			}]*/
		});
	}

}