import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class TipusProveidorClient extends RestapiResource {}

@Injectable()
export class TipusProveidorsClientService extends BngRestapiService<TipusProveidorClient> {

    constructor( injector: Injector ) {
        super( TipusProveidorClient, 'tipusProveidorClient', injector, 'fact' );
    }

}