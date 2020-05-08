import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { BngAuthGuard, BngModuleService } from 'base-angular';

import { SelectedEmpresaGuard } from '../../shared/selected-empresa.guard';

@NgModule({
	imports: [
		CommonModule,
		RouterModule.forChild([{
			path: 'cita',
			canActivate: [BngAuthGuard, SelectedEmpresaGuard],
			children: [{
				path: 'puntsVenda',
				loadChildren: () => import('./pages/puntsVenda/puntsVenda.module').then(m => m.PuntsVendaModule)
			}, {
				path: 'festiusGrup',
				loadChildren: () => import('./pages/festiusGrup/festiusGrup.module').then(m => m.FestiusGrupModule)
			}, {
				path: 'horaris',
				loadChildren: () => import('./pages/horaris/horaris.module').then(m => m.HorarisModule)
			}, {
				path: 'cites',
				loadChildren: () => import('./pages/cites/cites.module').then(m => m.CitesModule)
			}, {
				path: '**',
				redirectTo: 'puntsVenda'
			}]
		}])
	]
})
export class CitaModule {

	constructor(moduleService: BngModuleService) {
		moduleService.register({
			code: 'cita',
			icon: 'event',
			label: 'Cites',
			menuItems: [{
				icon: 'storefront',
				label: 'Punts de venda',
				labelKey: 'app.menu.cita.puntsVenda',
				route: '/cita/puntsVenda',
				resource: 'CIT_PUNVEN'
			}, {
				icon: 'beach_access',
				label: 'Grups de festius',
				labelKey: 'app.menu.cita.grupFestius',
				route: '/cita/festiusGrup',
				resource: 'CIT_GRPFES'
			}, {
				icon: 'view_comfy',
				label: 'Horaris',
				labelKey: 'app.menu.cita.horaris',
				route: '/cita/horaris',
				resource: 'CIT_HORARI'
			}, {
				icon: 'event',
				label: 'Cites',
				labelKey: 'app.menu.cita.cites',
				route: '/cita/cites',
				resource: 'CIT_CITA'
			}]
		});
	}

}