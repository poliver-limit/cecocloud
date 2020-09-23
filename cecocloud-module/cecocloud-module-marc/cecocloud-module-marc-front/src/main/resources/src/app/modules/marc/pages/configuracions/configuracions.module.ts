import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { BngModule, BngFormExitGuard } from 'base-angular';
import { TranslateModule } from '@ngx-translate/core';

import { MaterialModule } from '../../../../shared/material.module';

import { ConfiguracionsService } from './configuracions.service';
import { ConfiguracionsComponent } from './configuracions.component';


@NgModule( {
    imports: [
        CommonModule,
        FormsModule,
        ReactiveFormsModule,
        TranslateModule, 
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: ConfiguracionsComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ConfiguracionsComponent
    ],
    providers: [
        ConfiguracionsService
    ]
} )
export class ConfiguracionsModule {}