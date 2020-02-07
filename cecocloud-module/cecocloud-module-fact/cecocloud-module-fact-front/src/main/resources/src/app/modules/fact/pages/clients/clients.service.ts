import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Client extends Resource {}

@Injectable()
export class ClientsService extends BngRestapiService<Client> {

    constructor( injector: Injector ) {
        super( Client, 'client', injector, 'fact' );
    }

}