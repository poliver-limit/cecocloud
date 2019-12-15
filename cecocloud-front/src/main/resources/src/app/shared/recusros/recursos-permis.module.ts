import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslateModule } from '@ngx-translate/core';

import { MatTableModule } from '@angular/material';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';

import { PerfilRolService } from '../../pages/perfils/perfilRol.service';
import { MaterialModule } from '../material.module';
import { RecursosPermisComponent } from './recursos-permis.component';
import { RecursosService } from './recusros.service';
import { PerfilUsuariIdentificadorEmpresaService } from 'src/app/pages/identificador-usuaris/perfil-usuari-identificador-empresa.service';


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
        PerfilUsuariIdentificadorEmpresaService
    ],
    exports: [
        RecursosPermisComponent
    ]
})
export class RecusrosPermisModule { }