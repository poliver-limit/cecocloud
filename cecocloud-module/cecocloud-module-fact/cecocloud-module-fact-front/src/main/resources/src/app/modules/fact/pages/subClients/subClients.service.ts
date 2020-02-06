import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class SubClient extends Resource {}

@Injectable()
export class SubClientsService extends BngRestapiService<SubClient> {

    constructor( injector: Injector ) {
        super( SubClient, 'subClient', injector, 'fact' );
    }

}