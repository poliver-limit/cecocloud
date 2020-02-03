import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { RegistresDiariGridComponent } from './registresDiari-grid.component';
import { RegistresDiariFormComponent } from './registresDiari-form.component';
import { RegistresDiariService } from './registresDiari.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: RegistresDiariGridComponent },
            { path: 'create', component: RegistresDiariFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: RegistresDiariFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        RegistresDiariGridComponent,
        RegistresDiariFormComponent
    ],
    providers: [
        RegistresDiariService
    ]
} )
export class RegistresDiariModule {}