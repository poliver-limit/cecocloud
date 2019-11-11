import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { CompanyiaComponent } from './companyia.component';
import { CompanyiesService } from './companyies.service';

@NgModule( {
    imports: [
        CommonModule,
		FormsModule,
        ReactiveFormsModule,
        BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: CompanyiaComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        CompanyiaComponent
    ],
    providers: [
        CompanyiesService
    ]
} )
export class CompanyiaModule {}