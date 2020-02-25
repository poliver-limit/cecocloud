import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { SeriesVendaFormComponent } from './seriesVenda-form.component';
import { SeriesVendaService } from './seriesVenda.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        SeriesVendaFormComponent
    ],
	entryComponents: [
		SeriesVendaFormComponent
	],
	exports: [
		SeriesVendaFormComponent
	],
    providers: [
        SeriesVendaService
    ]
} )
export class SeriesVendaFormModule {}