import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { CaixesMovimentGridComponent } from './caixesMoviment-grid.component';
import { CaixesMovimentFormComponent } from './caixesMoviment-form.component';
import { CaixesMovimentService } from './caixesMoviment.service';

import { CaixesMovimentFormModule } from './caixesMoviment-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		CaixesMovimentFormModule,
        RouterModule.forChild( [
            { path: '', component: CaixesMovimentGridComponent },
            { path: 'create', component: CaixesMovimentFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: CaixesMovimentFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        CaixesMovimentGridComponent        
    ],
    providers: [
        CaixesMovimentService
    ]
} )
export class CaixesMovimentModule {}