import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class TipusClient extends Resource {}

@Injectable()
export class TipusClientsService extends BngRestapiService<TipusClient> {

    constructor( injector: Injector ) {
        super( TipusClient, 'tipusClient', injector, 'fact' );
    }

}