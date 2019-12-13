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
				loadChildren: () => import('./pages/index/index.module').then(m => m.IndexModule),
				canActivate: [BngAuthGuard]
	        },{
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
export class MarcModule {}