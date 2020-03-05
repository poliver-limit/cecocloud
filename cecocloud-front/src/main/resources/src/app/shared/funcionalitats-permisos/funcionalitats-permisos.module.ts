import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslateModule } from '@ngx-translate/core';

import { MatTableModule } from '@angular/material/table';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MAT_CHECKBOX_CLICK_ACTION } from '@angular/material/checkbox';
import { MatTooltipModule } from '@angular/material/tooltip';

import { MaterialModule } from '../material.module';
import { FuncionalitatsPermisosComponent } from './funcionalitats-permisos.component';
import { PerfilUsuariIdentificadorEmpresaService } from './perfil-usuari-identificador-empresa.service';
import { PerfilService } from './perfil.service';

@NgModule({
    imports: [
        CommonModule,
        TranslateModule,
        MaterialModule,
        MatTableModule,
        MatSlideToggleModule,
        MatTooltipModule
    ],
    declarations: [
        FuncionalitatsPermisosComponent
    ],
    providers: [
        PerfilService,
        PerfilUsuariIdentificadorEmpresaService,
        { provide: MAT_CHECKBOX_CLICK_ACTION, useValue: 'noop' }
    ],
    exports: [
        FuncionalitatsPermisosComponent
    ]
})
export class FuncionalitatsPermisosModule { }