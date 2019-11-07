import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { MarcatgesGridComponent } from './marcatges-grid.component';
import { MarcatgesFormComponent } from './marcatges-form.component';
import { MarcatgesService } from './marcatges.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: MarcatgesGridComponent },
            { path: 'create', component: MarcatgesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: MarcatgesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        MarcatgesGridComponent,
        MarcatgesFormComponent
    ],
    providers: [
        MarcatgesService
    ]
} )
export class MarcatgesModule {}