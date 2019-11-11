import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { BngAuthGuard } from 'base-angular';

@NgModule({
	imports: [
		CommonModule,
		RouterModule.forChild([{
			path: '',
			loadChildren: './pages/index/index.module#IndexModule',
			canActivate: [BngAuthGuard]
        },{
			path: 'operaris',
			loadChildren: './pages/operaris/operaris.module#OperarisModule',
			canActivate: [BngAuthGuard]
		}, {
			path: 'marcatges',
			loadChildren: './pages/marcatges/marcatges.module#MarcatgesModule',
			canActivate: [BngAuthGuard]
		}, {
			path: '**',
			redirectTo: ''
		}])
    ]
})
export class MarcModule {}