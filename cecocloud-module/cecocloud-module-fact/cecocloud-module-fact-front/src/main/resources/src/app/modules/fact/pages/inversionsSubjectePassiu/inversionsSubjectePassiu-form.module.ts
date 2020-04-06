import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { InversionsSubjectePassiuFormComponent } from './inversionsSubjectePassiu-form.component';
import { InversionsSubjectePassiuService } from './inversionsSubjectePassiu.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        InversionsSubjectePassiuFormComponent
    ],
	entryComponents: [
		InversionsSubjectePassiuFormComponent
	],
	exports: [
		InversionsSubjectePassiuFormComponent
	],
    providers: [
        InversionsSubjectePassiuService
    ]
} )
export class InversionsSubjectePassiuFormModule {}