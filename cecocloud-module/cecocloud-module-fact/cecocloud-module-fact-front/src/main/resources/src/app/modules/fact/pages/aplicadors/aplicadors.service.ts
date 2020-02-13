import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Aplicador extends RestapiResource {}

@Injectable()
export class AplicadorsService extends BngRestapiService<Aplicador> {

    constructor( injector: Injector ) {
        super( Aplicador, 'aplicador', injector, 'fact' );
    }

}