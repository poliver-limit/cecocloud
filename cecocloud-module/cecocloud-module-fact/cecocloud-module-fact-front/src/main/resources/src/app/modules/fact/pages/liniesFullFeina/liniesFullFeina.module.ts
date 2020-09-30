import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { LiniesFullFeinaGridComponent } from './liniesFullFeina-grid.component';
import { LiniesFullFeinaFormComponent } from './liniesFullFeina-form.component';
import { LiniesFullFeinaService } from './liniesFullFeina.service';
import { FinalFacturesFormModule } from '../finalFactures/finalFactures-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
        MaterialModule,
        FinalFacturesFormModule,
        RouterModule.forChild( [
            { path: '', component: LiniesFullFeinaGridComponent },
            { path: 'create', component: LiniesFullFeinaFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: LiniesFullFeinaFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        LiniesFullFeinaGridComponent,
        LiniesFullFeinaFormComponent
    ],
    providers: [
        LiniesFullFeinaService
    ]
} )
export class LiniesFullFeinaModule {}