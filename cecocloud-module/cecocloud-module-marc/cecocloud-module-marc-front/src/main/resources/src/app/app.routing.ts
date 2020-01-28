import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BngAuthGuard } from 'base-angular';

export const routes: Routes = [{
    path: 'marc',
    loadChildren: () => import('./modules/marc/marc.module').then(m => m.MarcModule),
    canActivate: [BngAuthGuard]
}, {
    path: '**',
    redirectTo: 'marc'
}];

@NgModule({
    imports: [
        RouterModule.forRoot(routes, { enableTracing: false })],
    declarations: [],
    exports: [
        RouterModule]
})
export class AppRoutingModule { }
