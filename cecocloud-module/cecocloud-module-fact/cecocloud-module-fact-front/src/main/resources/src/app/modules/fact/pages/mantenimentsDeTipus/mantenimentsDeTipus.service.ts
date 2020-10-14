import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class MantenimentDeTipus extends RestapiResource {}

@Injectable()
export class MantenimentsDeTipusService extends BngRestapiService<MantenimentDeTipus> {

    constructor( injector: Injector ) {
        super( MantenimentDeTipus, 'mantenimentDeTipus', injector, 'fact' );
    }

}