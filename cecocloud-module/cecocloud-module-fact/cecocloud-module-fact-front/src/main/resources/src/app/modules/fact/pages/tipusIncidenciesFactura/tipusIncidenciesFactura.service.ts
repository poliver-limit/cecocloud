import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class TipusIncidenciaFactura extends RestapiResource {}

@Injectable()
export class TipusIncidenciesFacturaService extends BngRestapiService<TipusIncidenciaFactura> {

    constructor( injector: Injector ) {
        super( TipusIncidenciaFactura, 'tipusIncidenciaFactura', injector, 'fact' );
    }

}