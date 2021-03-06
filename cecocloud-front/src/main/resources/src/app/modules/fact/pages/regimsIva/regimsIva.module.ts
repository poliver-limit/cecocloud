import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { RegimsIvaGridComponent } from './regimsIva-grid.component';
import { RegimsIvaFormComponent } from './regimsIva-form.component';
import { RegimsIvaService } from './regimsIva.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: RegimsIvaGridComponent },
            { path: 'create', component: RegimsIvaFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: RegimsIvaFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        RegimsIvaGridComponent,
        RegimsIvaFormComponent
    ],
    providers: [
        RegimsIvaService
    ]
} )
export class RegimsIvaModule {}