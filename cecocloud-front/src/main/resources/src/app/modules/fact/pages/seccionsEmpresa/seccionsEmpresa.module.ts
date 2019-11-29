import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { SeccionsEmpresaGridComponent } from './seccionsEmpresa-grid.component';
import { SeccionsEmpresaFormComponent } from './seccionsEmpresa-form.component';
import { SeccionsEmpresaService } from './seccionsEmpresa.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: SeccionsEmpresaGridComponent },
            { path: 'create', component: SeccionsEmpresaFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: SeccionsEmpresaFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        SeccionsEmpresaGridComponent,
        SeccionsEmpresaFormComponent
    ],
    providers: [
        SeccionsEmpresaService
    ]
} )
export class SeccionsEmpresaModule {}