import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
/*import { HttpClient } from '@angular/common/http';
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';*/
import { BngAuthGuard, BngModuleService } from 'base-angular';

/*export function HttpLoaderFactory(http: HttpClient) {
	return new TranslateHttpLoader(http, "./assets/i18n/marc/", ".json");
}*/

@NgModule({
	imports: [
		CommonModule,
		/*TranslateModule.forChild({
			loader: {
				provide: TranslateLoader,
				useFactory: HttpLoaderFactory,
				deps: [HttpClient]
			},
			isolate: true
		}),*/
		RouterModule.forChild([{
			path: 'marc',
			children: [{
				path: '',
				loadChildren: () => import('./pages/index/index.module').then(m => m.IndexModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'operaris',
				loadChildren: () => import('./pages/operaris/operaris.module').then(m => m.OperarisModule),
				canActivate: [BngAuthGuard]
			}, {
				path: 'marcatges',
				loadChildren: () => import('./pages/marcatges/marcatges.module').then(m => m.MarcatgesModule),
				canActivate: [BngAuthGuard]
			}, {
				path: '**',
				redirectTo: ''
			}]
		}])
	]
})
export class MarcModule {

	constructor(moduleService: BngModuleService) {
		console.log('>>> Registrant mòdul marc')
		moduleService.register({
			code: 'marc',
			icon: 'touch_app',
			label: 'Marcatges',
			menuItems: [{
				icon: 'people_alt',
				label: 'Operaris',
				labelKey: 'app.menu.marc.operaris',
				route: '/marc/operaris'
			},{
				icon: 'timer',
				label: 'Marcatges',
				labelKey: 'app.menu.marc.marcatges',
				route: '/marc/marcatges'
			}]
		});
	}

}