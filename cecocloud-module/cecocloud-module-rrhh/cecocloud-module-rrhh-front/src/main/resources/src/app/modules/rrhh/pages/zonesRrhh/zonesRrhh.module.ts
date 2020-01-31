import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { ZonesRrhhGridComponent } from './zonesRrhh-grid.component';
import { ZonesRrhhFormComponent } from './zonesRrhh-form.component';
import { ZonesRrhhService } from './zonesRrhh.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: ZonesRrhhGridComponent },
            { path: 'create', component: ZonesRrhhFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ZonesRrhhFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ZonesRrhhGridComponent,
        ZonesRrhhFormComponent
    ],
    providers: [
        ZonesRrhhService
    ]
} )
export class ZonesRrhhModule {}