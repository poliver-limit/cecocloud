import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class TipusAdresa extends RestapiResource {}

@Injectable()
export class TipusAdrecesService extends BngRestapiService<TipusAdresa> {

    constructor( injector: Injector ) {
        super( TipusAdresa, 'tipusAdresa', injector, 'fact' );
    }

}