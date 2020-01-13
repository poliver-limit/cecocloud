import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Zona extends Resource {}

@Injectable()
export class ZonesService extends BngRestapiService<Zona> {

    constructor( injector: Injector ) {
        super( Zona, 'zona', injector, 'fact' );
    }

}