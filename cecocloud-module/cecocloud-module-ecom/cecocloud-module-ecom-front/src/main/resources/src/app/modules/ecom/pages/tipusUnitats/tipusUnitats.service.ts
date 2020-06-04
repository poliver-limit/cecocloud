import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class TipusUnitat extends RestapiResource {}

@Injectable()
export class TipusUnitatsService extends BngRestapiService<TipusUnitat> {

    constructor( injector: Injector ) {
        super( TipusUnitat, 'tipusUnitat', injector, 'ecom' );
    }

}