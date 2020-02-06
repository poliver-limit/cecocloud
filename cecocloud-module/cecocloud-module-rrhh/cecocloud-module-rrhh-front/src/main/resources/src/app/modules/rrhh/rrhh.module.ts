import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { BngAuthGuard, BngModuleService } from 'base-angular';

import { SelectedEmpresaGuard } from '../../shared/selected-empresa.guard';

@NgModule({
	imports: [
		CommonModule,
		RouterModule.forChild([{
			path: 'rrhh',
			canActivate: [BngAuthGuard, SelectedEmpresaGuard],
			children: [{
				path: '',
				loadChildren: () => import('./pages/index/index-rrhh.module').then(m => m.IndexRrhhModule)
			}, {
				path: 'calendaris',
				loadChildren: () => import('./pages/calendaris/calendaris.module').then(m => m.CalendarisModule)
			}, {
				path: 'categories',
				loadChildren: () => import('./pages/categories/categories.module').then(m => m.CategoriesModule)
			}, {
				path: 'empresesRrhh',
				loadChildren: () => import('./pages/empresesRrhh/empresesRrhh.module').then(m => m.EmpresesRrhhModule)
			}, {
				path: 'grupsFestiu',
				loadChildren: () => import('./pages/grupsFestiu/grupsFestiu.module').then(m => m.GrupsFestiuModule)
			}, {
				path: 'horaris',
				loadChildren: () => import('./pages/horaris/horaris.module').then(m => m.HorarisModule)
			}, {
				path: 'identificadorsRrhh',
				loadChildren: () => import('./pages/identificadorsRrhh/identificadorsRrhh.module').then(m => m.IdentificadorsRrhhModule)
			}, {
				path: 'intervals',
				loadChildren: () => import('./pages/intervals/intervals.module').then(m => m.IntervalsModule)
			}, {
				path: 'nodes',
				loadChildren: () => import('./pages/nodes/nodes.module').then(m => m.NodesModule)
			}, {
				path: 'operarisRrhh',
				loadChildren: () => import('./pages/operarisRrhh/operarisRrhh.module').then(m => m.OperarisRrhhModule)
//			}, {
//				path: 'paisosNif',
//				loadChildren: () => import('./pages/paisosNif/paisosNif.module').then(m => m.PaisosNifModule)
			}, {
				path: 'parametres',
				loadChildren: () => import('./pages/parametres/parametres.module').then(m => m.ParametresModule)
			}, {
				path: 'recursosGrup',
				loadChildren: () => import('./pages/recursosGrup/recursosGrup.module').then(m => m.RecursosGrupModule)
			}, {
				path: 'regims',
				loadChildren: () => import('./pages/regims/regims.module').then(m => m.RegimsModule)
			}, {
				path: 'registresDiari',
				loadChildren: () => import('./pages/registresDiari/registresDiari.module').then(m => m.RegistresDiariModule)
			}, {
				path: 'seccions',
				loadChildren: () => import('./pages/seccions/seccions.module').then(m => m.SeccionsModule)
			}, {
				path: 'seccionsGrup',
				loadChildren: () => import('./pages/seccionsGrup/seccionsGrup.module').then(m => m.SeccionsGrupModule)
			}, {
				path: 'servidors',
				loadChildren: () => import('./pages/servidors/servidors.module').then(m => m.ServidorsModule)
			}, {
				path: 'subcategories',
				loadChildren: () => import('./pages/subcategories/subcategories.module').then(m => m.SubcategoriesModule)
			}, {
				path: 'tipusDies',
				loadChildren: () => import('./pages/tipusDies/tipusDies.module').then(m => m.TipusDiesModule)
			}, {
				path: 'tipusTransaccions',
				loadChildren: () => import('./pages/tipusTransaccions/tipusTransaccions.module').then(m => m.TipusTransaccionsModule)
			}, {
				path: 'transaccions',
				loadChildren: () => import('./pages/transaccions/transaccions.module').then(m => m.TransaccionsModule)
			}, {
				path: 'zonesRrhh',
				loadChildren: () => import('./pages/zonesRrhh/zonesRrhh.module').then(m => m.ZonesRrhhModule)
			}, {
				path: '**',
				redirectTo: ''
			}]
		}])
	]
})
export class RrhhModule {

	constructor(moduleService: BngModuleService) {
		moduleService.register({
			code: 'rrhh',
			icon: 'people_alt',
			label: 'Recursos humans',
			menuItems: [{
				icon: 'room',
				label: 'Calendaris',
				labelKey: 'app.menu.rrhh.calendaris',
				route: '/rrhh/calendaris'
			}, {
				icon: 'room',
				label: 'Categories',
				labelKey: 'app.menu.rrhh.categories',
				route: '/rrhh/categories'
			}, {
				icon: 'room',
				label: 'Grups festius',
				labelKey: 'app.menu.rrhh.grupsFestius',
				route: '/rrhh/grupsFestiu'
			}, {
				icon: 'room',
				label: 'Horaris',
				labelKey: 'app.menu.rrhh.horaris',
				route: '/rrhh/horaris'
			}, {
				icon: 'room',
				label: 'Intervals',
				labelKey: 'app.menu.rrhh.intervals',
				route: '/rrhh/intervals'
			}, {
				icon: 'room',
				label: 'Nodes',
				labelKey: 'app.menu.rrhh.nodes',
				route: '/rrhh/nodes'
			}, {
				icon: 'room',
				label: 'Operaris',
				labelKey: 'app.menu.rrhh.operaris',
				route: '/rrhh/operarisRrhh'
			}, {
				icon: 'room',
				label: 'Parametres',
				labelKey: 'app.menu.rrhh.parametres',
				route: '/rrhh/parametres'
			}, {
				icon: 'room',
				label: 'Recursos Grup',
				labelKey: 'app.menu.rrhh.recursosGrups',
				route: '/rrhh/recursosGrup'
			}, {
				icon: 'room',
				label: 'Regims',
				labelKey: 'app.menu.rrhh.regims',
				route: '/rrhh/regims'
			}, {
				icon: 'room',
				label: 'Registres Diaris',
				labelKey: 'app.menu.rrhh.registresDiaris',
				route: '/rrhh/registresDiari'
			}, {
				icon: 'room',
				label: 'Seccions',
				labelKey: 'app.menu.rrhh.seccions',
				route: '/rrhh/seccions'
			}, {
				icon: 'room',
				label: 'Seccions Grup',
				labelKey: 'app.menu.rrhh.seccionsGrups',
				route: '/rrhh/seccionsGrup'
			}, {
				icon: 'room',
				label: 'Servidors',
				labelKey: 'app.menu.rrhh.servidors',
				route: '/rrhh/servidors'
			}, {
				icon: 'room',
				label: 'Subcategories',
				labelKey: 'app.menu.rrhh.subcategories',
				route: '/rrhh/subcategories'
			}, {
				icon: 'room',
				label: 'Tipus Dia',
				labelKey: 'app.menu.rrhh.tipusDies',
				route: '/rrhh/tipusDies'
			}, {
				icon: 'room',
				label: 'Tipus Transaccio',
				labelKey: 'app.menu.rrhh.tipusTransaccions',
				route: '/rrhh/tipusTransaccions'
			}, {
				icon: 'room',
				label: 'Transaccions',
				labelKey: 'app.menu.rrhh.transaccions',
				route: '/rrhh/transaccions'
			}, {
				icon: 'room',
				label: 'Zones',
				labelKey: 'app.menu.rrhh.zones',
				route: '/rrhh/zonesRrhh'
			}]
		});
	}
	
}