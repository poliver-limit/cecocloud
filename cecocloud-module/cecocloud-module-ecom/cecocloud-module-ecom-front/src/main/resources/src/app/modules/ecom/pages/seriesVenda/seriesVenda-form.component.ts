import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { SeriesVendaService } from './seriesVenda.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="seriesVendaService"></bng-form>
`
} )
export class SeriesVendaFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

   constructor(
		activatedRoute: ActivatedRoute,
        public seriesVendaService: SeriesVendaService ) {
			super(activatedRoute);
		}
}