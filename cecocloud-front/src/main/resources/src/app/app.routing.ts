import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BngAuthGuard } from 'base-angular';

export const routes: Routes = [{
    path: '',
    loadChildren: './pages/home/home.module#HomeModule',
    canActivate: [BngAuthGuard]
}, {
    path: 'login',
    loadChildren: './pages/login/login.module#LoginModule'
}, {
    path: 'registre',
    loadChildren: './pages/registre/registre.module#RegistreModule'
}, {
    path: 'usuaris',
    loadChildren: './pages/usuaris/usuaris.module#UsuarisModule',
    canActivate: [BngAuthGuard]
}, {
    path: 'rols',
    loadChildren: './pages/rols/rols.module#RolsModule',
    canActivate: [BngAuthGuard]
}, {
    path: 'perfils',
    loadChildren: './pages/perfils/perfils.module#PerfilsModule',
    canActivate: [BngAuthGuard]
}, {
    path: 'companyies',
    loadChildren: './pages/companyies/companyies.module#CompanyiesModule',
    canActivate: [BngAuthGuard]
}, {
    path: 'empreses',
    loadChildren: './modules/empreses/empreses.module#EmpresesModule',
    canActivate: [BngAuthGuard]
}, {
    path: 'marc',
    loadChildren: './module/marc/marc.module#MarcModule',
    canActivate: [BngAuthGuard]
}, {
    path: '**',
    redirectTo: ''
}];

@NgModule( {
    imports: [
        RouterModule.forRoot( routes )],
    declarations: [],
    exports: [
        RouterModule]
} )
export class AppRoutingModule { }
