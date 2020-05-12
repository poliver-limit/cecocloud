import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Cita extends RestapiResource {}

@Injectable()
export class CitesService extends BngRestapiService<Cita> {

    constructor( injector: Injector ) {
        super( Cita, 'cita', injector, 'cita' );
    }

}