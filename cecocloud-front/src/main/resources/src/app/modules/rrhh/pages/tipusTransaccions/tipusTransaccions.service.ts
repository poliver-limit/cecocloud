import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class TipusTransaccio extends Resource {}

@Injectable()
export class TipusTransaccionsService extends BngRestapiService<TipusTransaccio> {

    constructor( injector: Injector ) {
        super( TipusTransaccio, 'tipusTransaccio', injector, 'rrhh' );
    }

}