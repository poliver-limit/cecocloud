import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { ComptesComptablesEmpresaGridComponent } from './comptesComptablesEmpresa-grid.component';
import { ComptesComptablesEmpresaFormComponent } from './comptesComptablesEmpresa-form.component';
import { ComptesComptablesEmpresaService } from './comptesComptablesEmpresa.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: ComptesComptablesEmpresaGridComponent },
            { path: 'create', component: ComptesComptablesEmpresaFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ComptesComptablesEmpresaFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ComptesComptablesEmpresaGridComponent,
        ComptesComptablesEmpresaFormComponent
    ],
    providers: [
        ComptesComptablesEmpresaService
    ]
} )
export class ComptesComptablesEmpresaModule {}