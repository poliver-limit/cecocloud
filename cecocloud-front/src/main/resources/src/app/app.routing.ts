import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BngAuthGuard } from 'base-angular';

export const routes: Routes = [{
    path: '',
    loadChildren: './modules/home/home.module#HomeModule',
    canActivate: [BngAuthGuard]
}, {
    path: 'login',
    loadChildren: './modules/login/login.module#LoginModule'
}, {
    path: 'registre',
    loadChildren: './modules/registre/registre.module#RegistreModule'
}, {
    path: 'usuaris',
    loadChildren: './modules/usuaris/usuaris.module#UsuarisModule',
    canActivate: [BngAuthGuard]
}, {
    path: 'companyies',
    loadChildren: './modules/companyies/companyies.module#CompanyiesModule',
    canActivate: [BngAuthGuard]
}, {
    path: 'empreses',
    loadChildren: './modules/empreses/empreses.module#EmpresesModule',
    canActivate: [BngAuthGuard]
}, {
    path: 'operaris',
    loadChildren: './modules/operaris/operaris.module#OperarisModule',
    canActivate: [BngAuthGuard]
}, {
    path: 'marcatges',
    loadChildren: './modules/marcatges/marcatges.module#MarcatgesModule',
    canActivate: [BngAuthGuard]
}, {
    path: 'cpktest',
    loadChildren: './modules/cpktest/cpktest.module#CpktestModule',
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
