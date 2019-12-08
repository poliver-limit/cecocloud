import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslateModule } from '@ngx-translate/core';

import { MatTableModule } from '@angular/material';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';

import { PerfilRolService } from '../pages/perfils/perfilRol.service';
import { PerfilUsuariEmpresaService } from '../pages/companyia-usuaris/perfil-usuari-empresa.service';
import { MaterialModule } from './material.module';
import { RecursosPermisComponent } from './recursos-permis.component';
import { RecursosService } from './recusros.service';


@NgModule({
    imports: [
        CommonModule,
        TranslateModule,
        MaterialModule,
        MatTableModule,
        MatSlideToggleModule
    ],
    declarations: [
        RecursosPermisComponent
    ],
    providers: [
        RecursosService,
        PerfilRolService,
        PerfilUsuariEmpresaService
    ],
    exports: [
        RecursosPermisComponent
    ]
})
export class RecusrosPermisModule { }