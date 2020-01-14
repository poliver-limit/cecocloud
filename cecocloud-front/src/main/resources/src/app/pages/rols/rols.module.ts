import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { RolsGridComponent } from './rols-grid.component';
import { RolsFormComponent } from './rols-form.component';
import { RolsService } from './rols.service';
import { RecursPermisosModule } from '../../shared/recurs-permisos/recurs-permisos.module';

@NgModule({
    imports: [
        CommonModule,
        TranslateModule,
        BngModule,
        MaterialModule,
        RecursPermisosModule,
        // MatTableModule,
        // MatSlideToggleModule,
        RouterModule.forChild([
            { path: '', component: RolsGridComponent },
            { path: 'create', component: RolsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: RolsFormComponent, canDeactivate: [BngFormExitGuard] }
        ])
    ],
    declarations: [
        RolsGridComponent,
        RolsFormComponent
        // RecursosPermisComponent
    ],
    providers: [
        RolsService
        // RecursosService,
        // PerfilRolService,
        // PerfilUsuariEmpresaService
    ]
})
export class RolsModule { }