import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Proveidor extends Resource {}

@Injectable()
export class ProveidorsService extends BngRestapiService<Proveidor> {

    constructor( injector: Injector ) {
        super( Proveidor, 'proveidor', injector, 'fact' );
    }

}