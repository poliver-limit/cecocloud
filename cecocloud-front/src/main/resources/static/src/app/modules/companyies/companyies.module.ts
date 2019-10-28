import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { BngModule, BngFormExitGuard } from '@programari-limit/bang';

import { MaterialModule } from '../../shared/material.module';

import { CompanyiesGridComponent } from './companyies-grid.component';
import { CompanyiesFormComponent } from './companyies-form.component';
import { CompanyiesNomFieldComponent } from './companyies-nom-field.component';
import { CompanyiesService } from './companyies.service';
import { CompanyiesPermissionService } from './companyies-permission.service';

@NgModule( {
    imports: [
        CommonModule,
		FormsModule,
        ReactiveFormsModule,
        BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: CompanyiesGridComponent },
            { path: 'create', component: CompanyiesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: CompanyiesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        CompanyiesGridComponent,
        CompanyiesFormComponent,
        CompanyiesNomFieldComponent
    ],
    providers: [
        CompanyiesService,
        CompanyiesPermissionService
    ]
} )
export class CompanyiesModule {}