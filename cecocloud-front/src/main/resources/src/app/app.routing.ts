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
    path: 'companyies',
    loadChildren: () => import('./pages/companyies/companyies.module').then(m => m.CompanyiesModule),
    canActivate: [BngAuthGuard]
}, {
    path: 'admin-companyia',
    loadChildren: () => import('./pages/admin-companyia/admin-companyia.module').then(m => m.AdminCompanyiaModule),
    canActivate: [BngAuthGuard]
}, {
    path: 'companyia',
    loadChildren: () => import('./pages/companyia/companyia.module').then(m => m.CompanyiaModule),
    canActivate: [BngAuthGuard]
}, {
    path: 'companyia-usuaris',
    loadChildren: () => import('./pages/companyia-usuaris/companyia-usuaris.module').then(m => m.CompanyiaUsuarisModule),
    canActivate: [BngAuthGuard]
}, {
    path: 'identificadors',
    loadChildren: () => import('./pages/identificadors/identificadors.module').then(m => m.IdentificadorsModule),
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
