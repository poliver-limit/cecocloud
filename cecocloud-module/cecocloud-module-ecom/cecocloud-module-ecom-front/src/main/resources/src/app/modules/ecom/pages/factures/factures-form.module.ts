import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';
import { TranslateModule } from '@ngx-translate/core';

import { FacturesFormComponent } from './factures-form.component';
import { FacturesService } from './factures.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule,
		MaterialModule,
		TranslateModule
    ],
    declarations: [
        FacturesFormComponent
    ],
	entryComponents: [
		FacturesFormComponent
	],
	exports: [
		FacturesFormComponent
	],
    providers: [
        FacturesService
    ]
} )
export class FacturesFormModule {}