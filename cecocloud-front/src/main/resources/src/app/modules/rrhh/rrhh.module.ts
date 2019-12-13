import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { BngAuthGuard } from 'base-angular';

import { SelectedEmpresaGuard } from '../../shared/selected-empresa.guard';

@NgModule({
	imports: [
		CommonModule,
		RouterModule.forChild([{
			path: '',
			canActivate: [SelectedEmpresaGuard],
			children: [{
				path: '',
				loadChildren: () => import('./pages/index/index-rrhh.module').then(m => m.IndexRrhhModule),
				canActivate: [BngAuthGuard]				
			}, {
				path: 'calendaris',
				loadChildren: () => import('./pages/calendaris/calendaris.module').then(m => m.CalendarisModule),
				canActivate: [BngAuthGuard]
				
			}, {
				path: 'categories',
				loadChildren: () => import('./pages/categories/categories.module').then(m => m.CategoriesModule),
				canActivate: [BngAuthGuard]				
			}, {
				path: 'empreses',
				loadChildren: () => import('./pages/empreses/empreses.module').then(m => m.EmpresesModule),
				canActivate: [BngAuthGuard]				
			}, {
				path: 'horaris',
				loadChildren: () => import('./pages/horaris/horaris.module').then(m => m.HorarisModule),
				canActivate: [BngAuthGuard]				
			}, {
				path: 'identificadors',
				loadChildren: () => import('./pages/identificadors/identificadors.module').then(m => m.IdentificadorsModule),
				canActivate: [BngAuthGuard]				
			}, {
				path: 'nodes',
				loadChildren: () => import('./pages/nodes/nodes.module').then(m => m.NodesModule),
				canActivate: [BngAuthGuard]				
			}, {
				path: 'operaris',
				loadChildren: () => import('./pages/operaris/operaris.module').then(m => m.OperarisModule),
				canActivate: [BngAuthGuard]				
			}, {
				path: 'parametres',
				loadChildren: () => import('./pages/parametres/parametres.module').then(m => m.ParametresModule),
				canActivate: [BngAuthGuard]				
			}, {
				path: 'recursosGrup',
				loadChildren: () => import('./pages/recursosGrup/recursosGrup.module').then(m => m.RecursosGrupModule),
				canActivate: [BngAuthGuard]				
			}, {
				path: 'regims',
				loadChildren: () => import('./pages/regims/regims.module').then(m => m.RegimsModule),
				canActivate: [BngAuthGuard]				
			}, {
				path: 'registresDiari',
				loadChildren: () => import('./pages/registresDiari/registresDiari.module').then(m => m.RegistresDiariModule),
				canActivate: [BngAuthGuard]				
			}, {
				path: 'seccions',
				loadChildren: () => import('./pages/seccions/seccions.module').then(m => m.SeccionsModule),
				canActivate: [BngAuthGuard]				
			}, {
				path: 'seccionsGrup',
				loadChildren: () => import('./pages/seccionsGrup/seccionsGrup.module').then(m => m.SeccionsGrupModule),
				canActivate: [BngAuthGuard]				
			}, {
				path: 'servidors',
				loadChildren: () => import('./pages/servidors/servidors.module').then(m => m.ServidorsModule),
				canActivate: [BngAuthGuard]				
			}, {
				path: 'subcategories',
				loadChildren: () => import('./pages/subcategories/subcategories.module').then(m => m.SubcategoriesModule),
				canActivate: [BngAuthGuard]				
			}, {
				path: 'tipusDies',
				loadChildren: () => import('./pages/tipusDies/tipusDies.module').then(m => m.TipusDiesModule),
				canActivate: [BngAuthGuard]				
			}, {
				path: 'tipusTransaccions',
				loadChildren: () => import('./pages/tipusTransaccions/tipusTransaccions.module').then(m => m.TipusTransaccionsModule),
				canActivate: [BngAuthGuard]				
			}, {
				path: 'transaccions',
				loadChildren: () => import('./pages/transaccions/transaccions.module').then(m => m.TransaccionsModule),
				canActivate: [BngAuthGuard]				
			}, {
				path: 'zones',
				loadChildren: () => import('./pages/zones/zones.module').then(m => m.ZonesModule),
				canActivate: [BngAuthGuard]		
			}, {
				path: '**',
				redirectTo: ''
			}]
		}])
    ]
})
export class RrhhModule {}