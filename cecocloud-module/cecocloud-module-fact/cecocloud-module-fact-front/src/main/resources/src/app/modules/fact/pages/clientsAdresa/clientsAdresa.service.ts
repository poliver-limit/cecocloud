import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class ClientAdresa extends RestapiResource {}

@Injectable()
export class ClientsAdresaService extends BngRestapiService<ClientAdresa> {

    constructor( injector: Injector ) {
        super( ClientAdresa, 'clientAdresa', injector, 'fact' );
    }

}