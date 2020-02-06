import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { PaisosGridComponent } from './paisos-grid.component';
import { PaisosFormComponent } from './paisos-form.component';
import { PaisosService } from './paisos.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: PaisosGridComponent },
            { path: 'create', component: PaisosFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: PaisosFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        PaisosGridComponent,
        PaisosFormComponent
    ],
    providers: [
        PaisosService
    ]
} )
export class PaisosModule {}