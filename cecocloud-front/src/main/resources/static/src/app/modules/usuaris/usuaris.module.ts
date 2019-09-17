import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { MantenimentModule } from '../../shared/manteniment.module';
import { MdcWebModule } from '../../shared/mdc-web.module';
import { RestapiFormExitGuard } from '../../shared/restapi-form/restapi-form-exit-guard';
import { UsuarisGridComponent } from './usuaris-grid.component';
import { UsuarisFormComponent } from './usuaris-form.component';
import { UsuarisService } from './usuaris.service';

@NgModule( {
    imports: [
        CommonModule,
        MdcWebModule,
        MantenimentModule,
        RouterModule.forChild( [
            { path: '', component: UsuarisGridComponent },
            { path: 'create', component: UsuarisFormComponent, canDeactivate: [RestapiFormExitGuard] },
            { path: 'update/:id', component: UsuarisFormComponent, canDeactivate: [RestapiFormExitGuard] }
        ] )
    ],
    declarations: [
        UsuarisGridComponent,
        UsuarisFormComponent
    ],
    providers: [
        UsuarisService
    ]
} )
export class UsuarisModule {}