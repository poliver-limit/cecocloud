import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class TipusClient extends RestapiResource {}

@Injectable()
export class TipusClientsService extends BngRestapiService<TipusClient> {

    constructor( injector: Injector ) {
        super( TipusClient, 'tipusClient', injector, 'fact' );
    }

}