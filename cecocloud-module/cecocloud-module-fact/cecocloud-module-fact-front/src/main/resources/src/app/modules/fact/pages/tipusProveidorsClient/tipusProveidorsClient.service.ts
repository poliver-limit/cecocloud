import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class TipusProveidorClient extends Resource {}

@Injectable()
export class TipusProveidorsClientService extends BngRestapiService<TipusProveidorClient> {

    constructor( injector: Injector ) {
        super( TipusProveidorClient, 'tipusProveidorClient', injector, 'fact' );
    }

}