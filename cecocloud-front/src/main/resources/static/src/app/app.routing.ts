import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AuthGuard } from './shared/auth/auth-guard';

export const routes: Routes = [{
    path: '',
    loadChildren: './modules/home/home.module#HomeModule',
    canActivate: [AuthGuard]
}, {
    path: 'login',
    loadChildren: './modules/login/login.module#LoginModule'
}, {
    path: 'registre',
    loadChildren: './modules/registre/registre.module#RegistreModule'
}, {
    path: 'usuaris',
    loadChildren: './modules/usuaris/usuaris.module#UsuarisModule',
    canActivate: [AuthGuard]
}, {
    path: 'companyies',
    loadChildren: './modules/companyies/companyies.module#CompanyiesModule',
    canActivate: [AuthGuard]
}, {
    path: 'empreses',
    loadChildren: './modules/empreses/empreses.module#EmpresesModule',
    canActivate: [AuthGuard]
}, {
    path: 'operaris',
    loadChildren: './modules/operaris/operaris.module#OperarisModule',
    canActivate: [AuthGuard]
}, {
    path: 'marcatges',
    loadChildren: './modules/marcatges/marcatges.module#MarcatgesModule',
    canActivate: [AuthGuard]
}, {
    path: 'cpktest',
    loadChildren: './modules/cpktest/cpktest.module#CpktestModule',
    canActivate: [AuthGuard]
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
