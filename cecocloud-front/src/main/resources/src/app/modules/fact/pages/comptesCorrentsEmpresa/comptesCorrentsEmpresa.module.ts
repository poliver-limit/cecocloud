import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { ComptesCorrentsEmpresaGridComponent } from './comptesCorrentsEmpresa-grid.component';
import { ComptesCorrentsEmpresaFormComponent } from './comptesCorrentsEmpresa-form.component';
import { ComptesCorrentsEmpresaService } from './comptesCorrentsEmpresa.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: ComptesCorrentsEmpresaGridComponent },
            { path: 'create', component: ComptesCorrentsEmpresaFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ComptesCorrentsEmpresaFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ComptesCorrentsEmpresaGridComponent,
        ComptesCorrentsEmpresaFormComponent
    ],
    providers: [
        ComptesCorrentsEmpresaService
    ]
} )
export class ComptesCorrentsEmpresaModule {}