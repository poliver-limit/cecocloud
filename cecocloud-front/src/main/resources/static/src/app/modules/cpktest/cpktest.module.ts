import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { MantenimentModule } from '../../shared/manteniment.module';
import { MdcWebModule } from '../../shared/mdc-web.module';
import { RestapiFormExitGuard } from '../../shared/restapi-form/restapi-form-exit-guard';
import { CpktestGridComponent } from './cpktest-grid.component';
import { CpktestFormComponent } from './cpktest-form.component';
import { CpktestService } from './cpktest.service';

@NgModule( {
    imports: [
        CommonModule,
        MdcWebModule,
        MantenimentModule,
        RouterModule.forChild( [
            { path: '', component: CpktestGridComponent },
            { path: 'create', component: CpktestFormComponent, canDeactivate: [RestapiFormExitGuard] },
            { path: 'update/:id', component: CpktestFormComponent, canDeactivate: [RestapiFormExitGuard] }
        ] )
    ],
    declarations: [
        CpktestGridComponent,
        CpktestFormComponent
    ],
    providers: [
        CpktestService
    ]
} )
export class CpktestModule {}