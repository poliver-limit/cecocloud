import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { SubClientsGridComponent } from './subClients-grid.component';
import { SubClientsFormComponent } from './subClients-form.component';
import { SubClientsService } from './subClients.service';

import { SubClientsFormModule } from './subClients-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		
		SubClientsFormModule,
		
        RouterModule.forChild( [
            { path: '', component: SubClientsGridComponent },
            { path: 'create', component: SubClientsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: SubClientsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        SubClientsGridComponent        
    ],
    providers: [
        SubClientsService
    ]
} )
export class SubClientsModule {}