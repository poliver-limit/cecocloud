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
				loadChildren: './pages/index/index-fact.module#IndexFactModule',
				canActivate: [BngAuthGuard]
	        }, {
				path: 'articles',
				loadChildren: './pages/articles/articles.module#ArticlesModule',
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
export class FactModule {}