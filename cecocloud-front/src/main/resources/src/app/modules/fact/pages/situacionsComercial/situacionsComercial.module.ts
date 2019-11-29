import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { SituacionsComercialGridComponent } from './situacionsComercial-grid.component';
import { SituacionsComercialFormComponent } from './situacionsComercial-form.component';
import { SituacionsComercialService } from './situacionsComercial.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: SituacionsComercialGridComponent },
            { path: 'create', component: SituacionsComercialFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: SituacionsComercialFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        SituacionsComercialGridComponent,
        SituacionsComercialFormComponent
    ],
    providers: [
        SituacionsComercialService
    ]
} )
export class SituacionsComercialModule {}