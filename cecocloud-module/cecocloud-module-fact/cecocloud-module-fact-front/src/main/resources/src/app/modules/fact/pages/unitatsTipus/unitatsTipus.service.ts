import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class UnitatTipus extends RestapiResource {}

@Injectable()
export class UnitatsTipusService extends BngRestapiService<UnitatTipus> {

    constructor( injector: Injector ) {
        super( UnitatTipus, 'unitatTipus', injector, 'fact' );
    }

}