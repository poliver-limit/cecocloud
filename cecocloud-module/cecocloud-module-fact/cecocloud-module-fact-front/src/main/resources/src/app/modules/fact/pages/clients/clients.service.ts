import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Client extends RestapiResource {}

@Injectable({
    providedIn: 'root'
})
export class ClientsService extends BngRestapiService<Client> {

    constructor( injector: Injector ) {
        super( Client, 'client', injector, 'fact' );
    }

}