import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Seccio extends RestapiResource {}

@Injectable()
export class SeccionsService extends BngRestapiService<Seccio> {

    constructor( injector: Injector ) {
        super( Seccio, 'seccio', injector, 'rrhh' );
    }

}