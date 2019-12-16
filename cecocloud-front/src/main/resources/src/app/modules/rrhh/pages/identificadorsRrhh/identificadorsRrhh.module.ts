import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { IdentificadorsRrhhGridComponent } from './identificadorsRrhh-grid.component';
import { IdentificadorsRrhhFormComponent } from './identificadorsRrhh-form.component';
import { IdentificadorsRrhhService } from './identificadorsRrhh.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: IdentificadorsRrhhGridComponent },
            { path: 'create', component: IdentificadorsRrhhFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: IdentificadorsRrhhFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        IdentificadorsRrhhGridComponent,
        IdentificadorsRrhhFormComponent
    ],
    providers: [
        IdentificadorsRrhhService
    ]
} )
export class IdentificadorsRrhhModule {}