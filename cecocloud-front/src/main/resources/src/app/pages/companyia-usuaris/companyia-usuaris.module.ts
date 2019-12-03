import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TranslateModule } from '@ngx-translate/core';
import { RouterModule } from '@angular/router';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { CompanyiaUsuarisGridComponent, CompanyiaUsuarisAddDialog } from './companyia-usuaris-grid.component';
import { CompanyiaUsuarisFormComponent } from './companyia-usuaris-form.component';
import { CompanyiaUsuarisService } from './companyia-usuaris.service';
import { UsuarisService } from './usuaris.service';
import { UsuariEmpresaService } from './../../shared/usuari-empresa.service';
import { PerfilUsuariEmpresaService } from './perfil-usuari-empresa.service';
import { PerfilsService } from './../perfils/perfils.service';
import { EmpresesService } from '../empreses/empreses.service';
import { MatTableModule } from '@angular/material';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        ReactiveFormsModule,
        TranslateModule,
        BngModule,
        MaterialModule,
        MatTableModule,
        RouterModule.forChild([
            { path: '', component: CompanyiaUsuarisGridComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: CompanyiaUsuarisFormComponent, canDeactivate: [BngFormExitGuard] }
        ])
    ],
    declarations: [
        CompanyiaUsuarisGridComponent,
        CompanyiaUsuarisFormComponent,
        CompanyiaUsuarisAddDialog
    ],
    providers: [
        CompanyiaUsuarisService,
        UsuarisService,
        EmpresesService,
        UsuariEmpresaService,
        PerfilsService,
        PerfilUsuariEmpresaService
    ],
    entryComponents: [
        CompanyiaUsuarisAddDialog
    ]
})
export class CompanyiaUsuarisModule { }