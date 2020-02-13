import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class TipusTransaccio extends RestapiResource {}

@Injectable()
export class TipusTransaccionsService extends BngRestapiService<TipusTransaccio> {

    constructor( injector: Injector ) {
        super( TipusTransaccio, 'tipusTransaccio', injector, 'rrhh' );
    }

}