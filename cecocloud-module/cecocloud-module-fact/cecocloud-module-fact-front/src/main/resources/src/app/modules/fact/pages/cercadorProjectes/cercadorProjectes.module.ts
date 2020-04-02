import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { CercadorProjectesSearchComponent } from './cercadorProjectes-search.component';
import { CercadorProjectesGridComponent } from './cercadorProjectes-grid.component';
import { CercadorProjectesService } from './cercadorProjectes.service';

//import {ReactiveFormsModule} from '@angular/forms';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
//		ReactiveFormsModule,
		
        RouterModule.forChild( [
			{ path: '', component: CercadorProjectesSearchComponent }		
        ] )
    ],
    declarations: [
		CercadorProjectesSearchComponent,
        CercadorProjectesGridComponent        
    ],
    providers: [
        CercadorProjectesService
    ]
} )
export class CercadorProjectesModule {}