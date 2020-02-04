import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
/*import { HttpClient } from '@angular/common/http';
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';*/
import { BngAuthGuard, BngModuleService } from 'base-angular';

import { SelectedEmpresaGuard } from '../../shared/selected-empresa.guard';

@NgModule({
	imports: [
		CommonModule,
		RouterModule.forChild([{
			path: 'marc',
			canActivate: [BngAuthGuard, SelectedEmpresaGuard],
			children: [{
				path: '',
				loadChildren: () => import('./pages/index/index.module').then(m => m.IndexModule)
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
			icon: 'touch_app',
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