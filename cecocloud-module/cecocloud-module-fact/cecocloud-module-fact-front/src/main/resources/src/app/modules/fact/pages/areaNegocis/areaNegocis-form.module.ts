import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { AreaNegocisFormComponent } from './areaNegocis-form.component';
import { AreaNegocisService } from './areaNegocis.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        AreaNegocisFormComponent
    ],
	entryComponents: [
		AreaNegocisFormComponent
	],
	exports: [
		AreaNegocisFormComponent
	],
    providers: [
        AreaNegocisService
    ]
} )
export class AreaNegocisFormModule {}