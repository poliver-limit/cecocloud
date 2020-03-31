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
				path: 'torns',
				loadChildren: () => import('./pages/torns/torns.module').then(m => m.TornsModule)
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
				route: '/rrhh/calendaris',
				resource: 'REH_CALEND'
			}, {
				icon: 'room',
				label: 'Categories',
				labelKey: 'app.menu.rrhh.categories',
				route: '/rrhh/categories',
				resource: 'REH_CATEGO'
			}, {
				icon: 'room',
				label: 'Grups festius',
				labelKey: 'app.menu.rrhh.grupsFestius',
				route: '/rrhh/grupsFestiu',
				resource: 'REH_GRUFES'
			}, {
				icon: 'room',
				label: 'Horaris',
				labelKey: 'app.menu.rrhh.horaris',
				route: '/rrhh/horaris',
				resource: 'REH_HORARI'
			}, {
				icon: 'room',
				label: 'Intervals',
				labelKey: 'app.menu.rrhh.intervals',
				route: '/rrhh/intervals',
				resource: 'REH_INTERV'
			}, {
				icon: 'room',
				label: 'Nodes',
				labelKey: 'app.menu.rrhh.nodes',
				route: '/rrhh/nodes',
				resource: 'REH_NODE'
			}, {
				icon: 'room',
				label: 'Operaris',
				labelKey: 'app.menu.rrhh.operaris',
				route: '/rrhh/operarisRrhh',
				resource: 'REH_OPERAR'
			}, {
				icon: 'room',
				label: 'Parametres',
				labelKey: 'app.menu.rrhh.parametres',
				route: '/rrhh/parametres',
				resource: 'REH_PARAME'
			}, {
				icon: 'room',
				label: 'Recursos Grup',
				labelKey: 'app.menu.rrhh.recursosGrups',
				route: '/rrhh/recursosGrup',
				resource: 'REH_RECGRU'
			}, {
				icon: 'room',
				label: 'Regims',
				labelKey: 'app.menu.rrhh.regims',
				route: '/rrhh/regims',
				resource: 'REH_REGIM'
			}, {
				icon: 'room',
				label: 'Registres Diaris',
				labelKey: 'app.menu.rrhh.registresDiaris',
				route: '/rrhh/registresDiari',
				resource: 'REH_REGDIA'
			}, {
				icon: 'room',
				label: 'Seccions',
				labelKey: 'app.menu.rrhh.seccions',
				route: '/rrhh/seccions',
				resource: 'REH_SECCIO'
			}, {
				icon: 'room',
				label: 'Seccions Grup',
				labelKey: 'app.menu.rrhh.seccionsGrups',
				route: '/rrhh/seccionsGrup',
				resource: 'REH_SECGRU'
			}, {
				icon: 'room',
				label: 'Servidors',
				labelKey: 'app.menu.rrhh.servidors',
				route: '/rrhh/servidors',
				resource: 'REH_SERVID'
			}, {
				icon: 'room',
				label: 'Subcategories',
				labelKey: 'app.menu.rrhh.subcategories',
				route: '/rrhh/subcategories',
				resource: 'REH_SUBCAT'
			}, {
				icon: 'room',
				label: 'Tipus Dia',
				labelKey: 'app.menu.rrhh.tipusDies',
				route: '/rrhh/tipusDies',
				resource: 'REH_TIPDIA'
			}, {
				icon: 'room',
				label: 'Tipus Transaccio',
				labelKey: 'app.menu.rrhh.tipusTransaccions',
				route: '/rrhh/tipusTransaccions',
				resource: 'REH_TIPTRA'
			}, {
				icon: 'room',
				label: 'Tornos',
				labelKey: 'app.menu.rrhh.torns',
				route: '/rrhh/torns',
				resource: 'REH_TORN'
			}, {
				icon: 'room',
				label: 'Transaccions',
				labelKey: 'app.menu.rrhh.transaccions',
				route: '/rrhh/transaccions',
				resource: 'REH_TRANSA'
			}, {
				icon: 'room',
				label: 'Zones',
				labelKey: 'app.menu.rrhh.zones',
				route: '/rrhh/zonesRrhh',
				resource: 'REH_ZONA'
			}]
		});
	}

}