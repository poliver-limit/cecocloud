import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Transaccio extends RestapiResource {}

@Injectable()
export class TransaccionsService extends BngRestapiService<Transaccio> {

    constructor( injector: Injector ) {
        super( Transaccio, 'transaccio', injector, 'rrhh' );
    }

}