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
			path: 'funcionalitats',
			loadChildren: () => import('./pages/funcionalitats/funcionalitats.module').then(m => m.FuncionalitatsModule),
			canActivate: [BngAuthGuard]
		}, {
			path: 'recursos',
			loadChildren: () => import('./pages/recursos/recursos.module').then(m => m.RecursosModule),
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
			path: 'operaris',
			loadChildren: () => import('./pages/operaris/operaris.module').then(m => m.OperarisModule),
			canActivate: [BngAuthGuard]
		}, {
			path: 'empreses',
			loadChildren: () => import('./pages/empreses/empreses.module').then(m => m.EmpresesModule),
			canActivate: [BngAuthGuard]
		}, {
			path: 'perfils',
			loadChildren: () => import('./pages/perfils/perfils.module').then(m => m.PerfilsModule),
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
