import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { CercadorClientsSearchComponent } from './cercadorClients-search.component';
import { CercadorClientsGridComponent } from './cercadorClients-grid.component';
import { CercadorClientsService } from './cercadorClients.service';

//import {ReactiveFormsModule} from '@angular/forms';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
//		ReactiveFormsModule,
		
        RouterModule.forChild( [
			{ path: '', component: CercadorClientsSearchComponent }		
        ] )
    ],
    declarations: [
		CercadorClientsSearchComponent,
        CercadorClientsGridComponent        
    ],
    providers: [
        CercadorClientsService
    ]
} )
export class CercadorClientsModule {}