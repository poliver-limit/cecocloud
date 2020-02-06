import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class ClientAdresa extends Resource {}

@Injectable()
export class ClientsAdresaService extends BngRestapiService<ClientAdresa> {

    constructor( injector: Injector ) {
        super( ClientAdresa, 'clientAdresa', injector, 'fact' );
    }

}