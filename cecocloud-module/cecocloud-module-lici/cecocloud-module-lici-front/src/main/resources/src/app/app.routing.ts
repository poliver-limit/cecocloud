import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BngAuthGuard } from 'base-angular';

export const routes: Routes = [{
    path: 'lici',
    loadChildren: () => import('./modules/lici/lici.module').then(m => m.LiciModule),
    canActivate: [BngAuthGuard]
}, {
    path: '**',
    redirectTo: 'lici'
}];

@NgModule({
    imports: [
        RouterModule.forRoot(routes, { enableTracing: false })],
    declarations: [],
    exports: [
        RouterModule]
})
export class AppRoutingModule { }
