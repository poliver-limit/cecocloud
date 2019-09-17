import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { MantenimentModule } from '../../shared/manteniment.module';
import { MdcWebModule } from '../../shared/mdc-web.module';
import { RestapiFormExitGuard } from '../../shared/restapi-form/restapi-form-exit-guard';
import { OperarisGridComponent } from './operaris-grid.component';
import { OperarisFormComponent } from './operaris-form.component';
import { OperarisService } from './operaris.service';

@NgModule( {
    imports: [
        CommonModule,
        MdcWebModule,
        MantenimentModule,
        RouterModule.forChild( [
            { path: '', component: OperarisGridComponent },
            { path: 'create', component: OperarisFormComponent, canDeactivate: [RestapiFormExitGuard] },
            { path: 'update/:id', component: OperarisFormComponent, canDeactivate: [RestapiFormExitGuard] }
        ] )
    ],
    declarations: [
        OperarisGridComponent,
        OperarisFormComponent
    ],
    providers: [
        OperarisService
    ]
} )
export class OperarisModule {}