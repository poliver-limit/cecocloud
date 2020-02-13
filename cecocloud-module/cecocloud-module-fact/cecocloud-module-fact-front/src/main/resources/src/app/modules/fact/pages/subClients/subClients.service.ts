import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class SubClient extends RestapiResource {}

@Injectable()
export class SubClientsService extends BngRestapiService<SubClient> {

    constructor( injector: Injector ) {
        super( SubClient, 'subClient', injector, 'fact' );
    }

}