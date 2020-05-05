import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BngAuthGuard } from 'base-angular';

export const routes: Routes = [{
    path: 'ecom',
    loadChildren: () => import('./modules/ecom/ecom.module').then(m => m.EcomModule),
    canActivate: [BngAuthGuard]
}, {
    path: '**',
    redirectTo: 'ecom'
}];

@NgModule({
    imports: [
        RouterModule.forRoot(routes, { enableTracing: false })],
    declarations: [],
    exports: [
        RouterModule]
})
export class AppRoutingModule { }
