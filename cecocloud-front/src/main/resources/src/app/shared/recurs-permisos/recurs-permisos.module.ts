import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslateModule } from '@ngx-translate/core';

import { MatTableModule } from '@angular/material';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';

import { MaterialModule } from '../material.module';
import { RecursPermisosComponent } from './recurs-permisos.component';
import { RecursPermisosService } from './recurs-permisos.service';
import { PerfilRolService } from './perfil-rol.service';
import { PerfilUsuariIdentificadorEmpresaService } from './perfil-usuari-identificador-empresa.service';


@NgModule({
    imports: [
        CommonModule,
        TranslateModule,
        MaterialModule,
        MatTableModule,
        MatSlideToggleModule
    ],
    declarations: [
        RecursPermisosComponent
    ],
    providers: [
        RecursPermisosService,
        PerfilRolService,
        PerfilUsuariIdentificadorEmpresaService
    ],
    exports: [
        RecursPermisosComponent
    ]
})
export class RecursPermisosModule { }