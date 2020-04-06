import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { ProveidorsFormComponent } from './proveidors-form.component';
import { ProveidorsService } from './proveidors.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        ProveidorsFormComponent
    ],
	entryComponents: [
		ProveidorsFormComponent
	],
	exports: [
		ProveidorsFormComponent
	],
    providers: [
        ProveidorsService
    ]
} )
export class ProveidorsFormModule {}