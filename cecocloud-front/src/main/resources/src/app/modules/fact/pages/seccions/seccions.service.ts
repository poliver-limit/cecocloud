import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Seccio extends Resource {}

@Injectable()
export class SeccionsService extends BngRestapiService<Seccio> {

    constructor( injector: Injector ) {
        super( Seccio, 'seccio', injector, 'fact' );
    }

}