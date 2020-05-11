import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { IdiomesGridComponent } from './idiomes-grid.component';
import { IdiomesFormComponent } from './idiomes-form.component';
import { IdiomesService } from './idiomes.service'; // No l'hem posat als Ives

import { IdiomesFormModule } from './idiomes-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		IdiomesFormModule,
        RouterModule.forChild( [
            { path: '', component: IdiomesGridComponent },
            { path: 'create', component: IdiomesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: IdiomesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        IdiomesGridComponent        
    ],
    providers: [
        IdiomesService
    ]
} )
export class IdiomesModule {}