import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BngAuthGuard } from 'base-angular';

export const routes: Routes = [{
    path: 'rrhh',
    loadChildren: () => import('./modules/rrhh/rrhh.module').then(m => m.RrhhModule),
    canActivate: [BngAuthGuard]
}, {
    path: '**',
    redirectTo: 'rrhh'
}];

@NgModule({
    imports: [
        RouterModule.forRoot(routes, { enableTracing: false })],
    declarations: [],
    exports: [
        RouterModule]
})
export class AppRoutingModule { }
