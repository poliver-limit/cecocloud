import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class CercadorClient extends RestapiResource {}

@Injectable()
export class CercadorClientsService extends BngRestapiService<CercadorClient> {

    constructor( injector: Injector ) {
        super( CercadorClient, 'client', injector, 'fact' );
    }

}