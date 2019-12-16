import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { OperarisRrhhGridComponent } from './operarisRrhh-grid.component';
import { OperarisRrhhFormComponent } from './operarisRrhh-form.component';
import { OperarisRrhhService } from './operarisRrhh.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: OperarisRrhhGridComponent },
            { path: 'create', component: OperarisRrhhFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: OperarisRrhhFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        OperarisRrhhGridComponent,
        OperarisRrhhFormComponent
    ],
    providers: [
        OperarisRrhhService
    ]
} )
export class OperarisRrhhModule {}