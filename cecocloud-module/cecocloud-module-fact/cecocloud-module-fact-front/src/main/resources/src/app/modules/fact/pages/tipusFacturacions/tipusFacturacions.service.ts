import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class TipusFacturacio extends RestapiResource {}

@Injectable()
export class TipusFacturacionsService extends BngRestapiService<TipusFacturacio> {

    constructor( injector: Injector ) {
        super( TipusFacturacio, 'tipusFacturacio', injector, 'fact' );
    }

}