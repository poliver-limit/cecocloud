import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class TipusRisc extends RestapiResource {}

@Injectable()
export class TipusRiscosService extends BngRestapiService<TipusRisc> {

    constructor( injector: Injector ) {
        super( TipusRisc, 'tipusRisc', injector, 'fact' );
    }

}