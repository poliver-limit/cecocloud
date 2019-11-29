import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class TipusFacturacio extends Resource {}

@Injectable()
export class TipusFacturacionsService extends BngRestapiService<TipusFacturacio> {

    constructor( injector: Injector ) {
        super( TipusFacturacio, 'tipusFacturacio', injector, 'fact' );
    }

}