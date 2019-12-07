import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';
import { MatTableModule } from '@angular/material';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';

import { RolsGridComponent } from './rols-grid.component';
import { RolsFormComponent } from './rols-form.component';
import { RecursosPermisComponent } from './recursos-permis.component';
import { RolsService } from './rols.service';
import { RecursosService } from 'src/app/shared/recusros.service';
import { PerfilRolService } from '../perfils/perfilRol.service';
import { PerfilUsuariEmpresaService } from '../companyia-usuaris/perfil-usuari-empresa.service';


@NgModule({
    imports: [
        CommonModule,
        TranslateModule,
        BngModule,
        MaterialModule,
        MatTableModule,
        MatSlideToggleModule,
        RouterModule.forChild([
            { path: '', component: RolsGridComponent },
            { path: 'create', component: RolsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: RolsFormComponent, canDeactivate: [BngFormExitGuard] }
        ])
    ],
    declarations: [
        RolsGridComponent,
        RolsFormComponent,
        RecursosPermisComponent
    ],
    providers: [
        RolsService,
        RecursosService,
        PerfilRolService,
        PerfilUsuariEmpresaService
    ]
})
export class RolsModule { }