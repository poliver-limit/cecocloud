import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { PerfilsGridComponent } from './perfils-grid.component';
import { PerfilsFormComponent } from './perfils-form.component';
import { PerfilsService } from './perfils.service';
import { FuncionalitatsPermisosModule } from '../../shared/funcionalitats-permisos/funcionalitats-permisos.module';

@NgModule({
    imports: [
        CommonModule,
        TranslateModule,
        BngModule,
        MaterialModule,
        FuncionalitatsPermisosModule,
        RouterModule.forChild([
            { path: '', component: PerfilsGridComponent },
            { path: 'create', component: PerfilsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: PerfilsFormComponent, canDeactivate: [BngFormExitGuard] }
        ])
    ],
    declarations: [
        PerfilsGridComponent,
        PerfilsFormComponent
    ],
    providers: [
        PerfilsService
    ]
})
export class PerfilsModule { }