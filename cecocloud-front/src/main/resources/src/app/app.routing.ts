import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { BngAuthGuard } from 'base-angular';

@NgModule({
	imports: [
		RouterModule.forRoot([{
			path: '',
			loadChildren: () => import('./pages/home/home.module').then(m => m.HomeModule),
			canActivate: [BngAuthGuard]
		}, {
			path: 'admin-app',
			loadChildren: () => import('./pages/admin-app/admin-app.module').then(m => m.AdminAppModule),
			canActivate: [BngAuthGuard]
		}, {
			path: 'admin-identificador',
			loadChildren: () => import('./pages/admin-identificador/admin-identificador.module').then(m => m.AdminIdentificadorModule),
			canActivate: [BngAuthGuard]
		}, {
			path: 'identificadors',
			loadChildren: () => import('./pages/identificadors/identificadors.module').then(m => m.IdentificadorsModule),
			canActivate: [BngAuthGuard]
		}, {
			path: 'identificador',
			loadChildren: () => import('./pages/identificador/identificador.module').then(m => m.IdentificadorModule),
			canActivate: [BngAuthGuard]
		}, {
			path: 'usuari-identificadors',
			loadChildren: () => import('./pages/usuari-identificadors/usuari-identificadors.module').then(m => m.UsuariIdentificadorsModule),
			canActivate: [BngAuthGuard]
		}, {
			path: 'perfils',
			loadChildren: () => import('./pages/perfils/perfils.module').then(m => m.PerfilsModule),
			canActivate: [BngAuthGuard]
		}, {
			path: 'empreses',
			loadChildren: () => import('./pages/empreses/empreses.module').then(m => m.EmpresesModule),
			canActivate: [BngAuthGuard]
		}, {
			path: '**',
			redirectTo: ''
		}], {
			enableTracing: false
		})],
	declarations: [],
	exports: [
		RouterModule]
})
export class AppRoutingModule { }
