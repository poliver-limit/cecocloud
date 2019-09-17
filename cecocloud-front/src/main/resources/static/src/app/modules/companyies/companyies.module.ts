import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

import { MantenimentModule } from '../../shared/manteniment.module';
import { MdcWebModule } from '../../shared/mdc-web.module';
import { AngularMaterialModule } from '../../shared/angular-material.module';
import { RestapiFormExitGuard } from '../../shared/restapi-form/restapi-form-exit-guard';
import { CompanyiesGridComponent } from './companyies-grid.component';
import { CompanyiesFormComponent } from './companyies-form.component';
import { CompanyiesNomFieldComponent } from './companyies-nom-field.component';
import { CompanyiesService } from './companyies.service';

@NgModule( {
    imports: [
        CommonModule,
        ReactiveFormsModule,
        MantenimentModule,
        MdcWebModule,
        AngularMaterialModule,
        RouterModule.forChild( [
            { path: '', component: CompanyiesGridComponent },
            { path: 'create', component: CompanyiesFormComponent, canDeactivate: [RestapiFormExitGuard] },
            { path: 'update/:id', component: CompanyiesFormComponent, canDeactivate: [RestapiFormExitGuard] }
        ] )
    ],
    declarations: [
        CompanyiesGridComponent,
        CompanyiesFormComponent,
        CompanyiesNomFieldComponent
    ],
    providers: [
        CompanyiesService
    ]
} )
export class CompanyiesModule {}