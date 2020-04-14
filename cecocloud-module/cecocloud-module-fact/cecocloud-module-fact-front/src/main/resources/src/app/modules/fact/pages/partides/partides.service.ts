import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Partida extends RestapiResource {}

@Injectable()
export class PartidesService extends BngRestapiService<Partida> {

    constructor( injector: Injector ) {
        super( Partida, 'partida', injector, 'fact' );
    }

}