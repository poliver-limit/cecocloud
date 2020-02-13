import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Recurs extends RestapiResource {}

@Injectable()
export class RecursosService extends BngRestapiService<Recurs> {

    constructor( injector: Injector ) {
        super( Recurs, 'recurs', injector );
    }

}