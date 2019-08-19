import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { MantenimentModule } from '../../shared/manteniment.module';
import { MaterialModule } from '../../shared/material.module';
import { CompanyiesGridComponent } from './companyies-grid.component';
import { CompanyiesFormComponent } from './companyies-form.component';
import { CompanyiesService } from './companyies.service';

@NgModule( {
    imports: [
        CommonModule,
        MantenimentModule,
        MaterialModule,
        RouterModule.forChild( [
            { path: '', component: CompanyiesGridComponent },
            { path: 'create', component: CompanyiesFormComponent },
            { path: 'update/:id', component: CompanyiesFormComponent }
        ] )
    ],
    declarations: [
        CompanyiesGridComponent,
        CompanyiesFormComponent
    ],
    providers: [
        CompanyiesService
    ]
} )
export class CompanyiesModule {}