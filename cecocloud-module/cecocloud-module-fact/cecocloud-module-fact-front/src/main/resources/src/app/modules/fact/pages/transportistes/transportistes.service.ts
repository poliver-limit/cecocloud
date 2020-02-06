import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Transportista extends Resource {}

@Injectable()
export class TransportistesService extends BngRestapiService<Transportista> {

    constructor( injector: Injector ) {
        super( Transportista, 'transportista', injector, 'fact' );
    }

}