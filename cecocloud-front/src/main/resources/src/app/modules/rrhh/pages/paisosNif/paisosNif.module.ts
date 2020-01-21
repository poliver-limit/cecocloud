import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { PaisosNifGridComponent } from './paisosNif-grid.component';
import { PaisosNifFormComponent } from './paisosNif-form.component';
import { PaisosNifService } from './paisosNif.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: PaisosNifGridComponent },
            { path: 'create', component: PaisosNifFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: PaisosNifFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        PaisosNifGridComponent,
        PaisosNifFormComponent
    ],
    providers: [
        PaisosNifService
    ]
} )
export class PaisosNifModule {}