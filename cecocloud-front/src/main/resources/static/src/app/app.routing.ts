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
