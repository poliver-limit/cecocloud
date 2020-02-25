import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { OficinesBancariesGridComponent } from './oficinesBancaries-grid.component';
import { OficinesBancariesFormComponent } from './oficinesBancaries-form.component';
import { OficinesBancariesService } from './oficinesBancaries.service';

import { OficinesBancariesFormModule } from './oficinesBancaries-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		OficinesBancariesFormModule,
        RouterModule.forChild( [
            { path: '', component: OficinesBancariesGridComponent },
            { path: 'create', component: OficinesBancariesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: OficinesBancariesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        OficinesBancariesGridComponent        
    ],
    providers: [
        OficinesBancariesService
    ]
} )
export class OficinesBancariesModule {}