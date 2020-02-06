import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Pais extends Resource {}

@Injectable()
export class PaisosService extends BngRestapiService<Pais> {

    constructor( injector: Injector ) {
        super( Pais, 'pais', injector, 'fact' );
    }

}