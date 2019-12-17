import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BngAuthGuard } from 'base-angular';

export const routes: Routes = [{
    path: '',
    loadChildren: () => import('./pages/home/home.module').then(m => m.HomeModule),
    canActivate: [BngAuthGuard]
}, {
    path: 'login',
    loadChildren: () => import('./pages/login/login.module').then(m => m.LoginModule)
}, {
    path: 'registre',
    loadChildren: () => import('./pages/registre/registre.module').then(m => m.RegistreModule)
}, {
    path: 'admin-app',
    loadChildren: () => import('./pages/admin-app/admin-app.module').then(m => m.AdminAppModule),
    canActivate: [BngAuthGuard]
}, {
    path: 'usuaris',
    loadChildren: () => import('./pages/usuaris/usuaris.module').then(m => m.UsuarisModule),
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
    path: 'rols',
    loadChildren: () => import('./pages/rols/rols.module').then(m => m.RolsModule),
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
    path: 'marc',
    loadChildren: () => import('./modules/marc/marc.module').then(m => m.MarcModule),
    canActivate: [BngAuthGuard]
}, {
    path: 'fact',
    loadChildren: () => import('./modules/fact/fact.module').then(m => m.FactModule),
    canActivate: [BngAuthGuard]
}, {
    path: 'rrhh',
    loadChildren: './modules/rrhh/rrhh.module#RrhhModule',
    canActivate: [BngAuthGuard]
}, {
    path: '**',
    redirectTo: ''
}];

@NgModule({
    imports: [
        RouterModule.forRoot(routes, { enableTracing: false })],
    declarations: [],
    exports: [
        RouterModule]
})
export class AppRoutingModule { }
