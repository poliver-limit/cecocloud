import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Avaria extends RestapiResource {}

@Injectable()
export class AvariesService extends BngRestapiService<Avaria> {

    constructor( injector: Injector ) {
        super( Avaria, 'avaria', injector, 'fact' );
    }

}