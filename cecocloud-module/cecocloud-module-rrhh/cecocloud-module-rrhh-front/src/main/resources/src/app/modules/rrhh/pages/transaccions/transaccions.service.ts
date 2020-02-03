import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Transaccio extends Resource {}

@Injectable()
export class TransaccionsService extends BngRestapiService<Transaccio> {

    constructor( injector: Injector ) {
        super( Transaccio, 'transaccio', injector, 'rrhh' );
    }

}