import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { GrupsFestiuGridComponent } from './grupsFestiu-grid.component';
import { GrupsFestiuFormComponent } from './grupsFestiu-form.component';
import { GrupsFestiuService } from './grupsFestiu.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: GrupsFestiuGridComponent },
            { path: 'create', component: GrupsFestiuFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: GrupsFestiuFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        GrupsFestiuGridComponent,
        GrupsFestiuFormComponent
    ],
    providers: [
        GrupsFestiuService
    ]
} )
export class GrupsFestiuModule {}