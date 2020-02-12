import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class CercadorClient extends Resource {}

@Injectable()
export class CercadorClientsService extends BngRestapiService<CercadorClient> {

    constructor( injector: Injector ) {
        super( CercadorClient, 'client', injector, 'fact' );
    }

}