import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class PaisNif extends Resource {}

@Injectable()
export class PaisosNifService extends BngRestapiService<PaisNif> {

    constructor( injector: Injector ) {
        super( PaisNif, 'paisNif', injector, 'rrhh' );
    }

}