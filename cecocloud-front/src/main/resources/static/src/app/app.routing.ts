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
    loadChildren: './modules/usuaris/usuaris.module#UsuarisModule'
}, {
    path: 'companyies',
    loadChildren: './modules/companyies/companyies.module#CompanyiesModule'
}, {
    path: 'empreses',
    loadChildren: './modules/empreses/empreses.module#EmpresesModule'
}, {
    path: 'operaris',
    loadChildren: './modules/operaris/operaris.module#OperarisModule'
}, {
    path: 'marcatges',
    loadChildren: './modules/marcatges/marcatges.module#MarcatgesModule'
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
