import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { VencimentsPagatFormComponent } from './vencimentsPagat-form.component';
import { VencimentsPagatService } from './vencimentsPagat.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        VencimentsPagatFormComponent
    ],
	entryComponents: [
		VencimentsPagatFormComponent
	],
	exports: [
		VencimentsPagatFormComponent
	],
    providers: [
        VencimentsPagatService
    ]
} )
export class VencimentsPagatFormModule {}