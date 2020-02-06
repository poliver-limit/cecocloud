import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class TipusIncidenciaFactura extends Resource {}

@Injectable()
export class TipusIncidenciesFacturaService extends BngRestapiService<TipusIncidenciaFactura> {

    constructor( injector: Injector ) {
        super( TipusIncidenciaFactura, 'tipusIncidenciaFactura', injector, 'fact' );
    }

}