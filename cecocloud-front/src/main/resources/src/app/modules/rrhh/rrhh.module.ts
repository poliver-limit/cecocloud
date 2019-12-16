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
				loadChildren: './pages/index/index-rrhh.module#IndexRrhhModule',
				canActivate: [BngAuthGuard]				
			}, {
				path: 'calendaris',
				loadChildren: './pages/calendaris/calendaris.module#CalendarisModule',
				canActivate: [BngAuthGuard]				
			}, {
				path: 'categories',
				loadChildren: './pages/categories/categories.module#CategoriesModule',
				canActivate: [BngAuthGuard]				
			}, {
				path: 'empreses',
				loadChildren: './pages/empresesRrhh/empresesRrhh.module#EmpresesRrhhModule',
				canActivate: [BngAuthGuard]				
			}, {
				path: 'horaris',
				loadChildren: './pages/horaris/horaris.module#HorarisModule',
				canActivate: [BngAuthGuard]				
			}, {
				path: 'identificadorsRrhh',
				loadChildren: './pages/identificadorsRrhh/identificadorsRrhh.module#IdentificadorsRrhhModule',
				canActivate: [BngAuthGuard]				
			}, {
				path: 'nodes',
				loadChildren: './pages/nodes/nodes.module#NodesModule',
				canActivate: [BngAuthGuard]				
			}, {
				path: 'operarisRrhh',
				loadChildren: './pages/operarisRrhh/operarisRrhh.module#OperarisRrhhModule',
				canActivate: [BngAuthGuard]				
			}, {
				path: 'parametres',
				loadChildren: './pages/parametres/parametres.module#ParametresModule',
				canActivate: [BngAuthGuard]				
			}, {
				path: 'recursosGrup',
				loadChildren: './pages/recursosGrup/recursosGrup.module#RecursosGrupModule',
				canActivate: [BngAuthGuard]				
			}, {
				path: 'regims',
				loadChildren: './pages/regims/regims.module#RegimsModule',
				canActivate: [BngAuthGuard]				
			}, {
				path: 'registresDiari',
				loadChildren: './pages/registresDiari/registresDiari.module#RegistresDiariModule',
				canActivate: [BngAuthGuard]				
			}, {
				path: 'seccions',
				loadChildren: './pages/seccions/seccions.module#SeccionsModule',
				canActivate: [BngAuthGuard]				
			}, {
				path: 'seccionsGrup',
				loadChildren: './pages/seccionsGrup/seccionsGrup.module#SeccionsGrupModule',
				canActivate: [BngAuthGuard]				
			}, {
				path: 'servidors',
				loadChildren: './pages/servidors/servidors.module#ServidorsModule',
				canActivate: [BngAuthGuard]				
			}, {
				path: 'subcategories',
				loadChildren: './pages/subcategories/subcategories.module#SubcategoriesModule',
				canActivate: [BngAuthGuard]				
			}, {
				path: 'tipusDies',
				loadChildren: './pages/tipusDies/tipusDies.module#TipusDiesModule',
				canActivate: [BngAuthGuard]				
			}, {
				path: 'tipusTransaccions',
				loadChildren: './pages/tipusTransaccions/tipusTransaccions.module#TipusTransaccionsModule',
				canActivate: [BngAuthGuard]				
			}, {
				path: 'transaccions',
				loadChildren: './pages/transaccions/transaccions.module#TransaccionsModule',
				canActivate: [BngAuthGuard]				
			}, {
				path: 'zones',
				loadChildren: './pages/zones/zones.module#ZonesModule',
				canActivate: [BngAuthGuard]		
			}, {
				path: '**',
				redirectTo: ''
			}]
		}])
    ]
})
export class RrhhModule {}