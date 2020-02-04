import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BngAuthGuard } from 'base-angular';

export const routes: Routes = [{
    path: 'fact',
    loadChildren: () => import('./modules/fact/fact.module').then(m => m.FactModule),
    canActivate: [BngAuthGuard]
}, {
    path: '**',
    redirectTo: 'fact'
}];

@NgModule({
    imports: [
        RouterModule.forRoot(routes, { enableTracing: false })],
    declarations: [],
    exports: [
        RouterModule]
})
export class AppRoutingModule { }
