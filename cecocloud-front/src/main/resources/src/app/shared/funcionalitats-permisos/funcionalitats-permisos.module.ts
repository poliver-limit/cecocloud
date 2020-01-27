import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslateModule } from '@ngx-translate/core';

import { MatTableModule } from '@angular/material';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';

import { MaterialModule } from '../material.module';
import { FuncionalitatsPermisosComponent } from './funcionalitats-permisos.component';
import { FuncionalitatsPermisosService } from './funcionalitats-permisos.service';
import { PerfilUsuariIdentificadorEmpresaService } from './perfil-usuari-identificador-empresa.service';
import { FuncionalitatsIdentificadorService } from './funcionalitats-identificador.service';


@NgModule({
    imports: [
        CommonModule,
        TranslateModule,
        MaterialModule,
        MatTableModule,
        MatSlideToggleModule
    ],
    declarations: [
        FuncionalitatsPermisosComponent
    ],
    providers: [
        FuncionalitatsPermisosService,
        PerfilUsuariIdentificadorEmpresaService,
        FuncionalitatsIdentificadorService
    ],
    exports: [
        FuncionalitatsPermisosComponent
    ]
})
export class FuncionalitatsPermisosModule { }