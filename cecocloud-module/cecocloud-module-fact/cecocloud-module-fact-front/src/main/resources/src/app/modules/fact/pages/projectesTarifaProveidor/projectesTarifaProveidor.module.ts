import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { ProjectesTarifaProveidorGridComponent } from './projectesTarifaProveidor-grid.component';
import { ProjectesTarifaProveidorFormComponent } from './projectesTarifaProveidor-form.component';
import { ProjectesTarifaProveidorService } from './projectesTarifaProveidor.service';

import { ProveidorsFormModule } from '../proveidors/proveidors-form.module'
import { TarifesProveidorFormModule } from '../tarifesProveidor/tarifesProveidor-form.module'

import { ProjectesTarifaProveidorFormModule } from './projectesTarifaProveidor-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		ProjectesTarifaProveidorFormModule,
		ProveidorsFormModule,   
		TarifesProveidorFormModule,		  
        RouterModule.forChild( [
            { path: '', component: ProjectesTarifaProveidorGridComponent },
            { path: 'create', component: ProjectesTarifaProveidorFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ProjectesTarifaProveidorFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ProjectesTarifaProveidorGridComponent        
    ],
    providers: [
        ProjectesTarifaProveidorService
    ]
} )
export class ProjectesTarifaProveidorModule {}