import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { BngAuthGuard } from 'base-angular';

@NgModule({
	imports: [
		CommonModule,
		RouterModule.forChild([
		{
			path: '',
			loadChildren: './pages/index/index-fact.module#IndexFactModule',
			canActivate: [BngAuthGuard]
        }, {
			path: 'zones',
			loadChildren: './pages/zones/zones.module#ZonesModule',
			canActivate: [BngAuthGuard]
		}, {
			path: '**',
			redirectTo: ''
		}])
    ]
})
export class FactModule {}