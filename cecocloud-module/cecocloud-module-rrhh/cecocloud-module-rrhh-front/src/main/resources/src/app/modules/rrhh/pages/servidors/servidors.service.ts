import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Servidor extends RestapiResource {}

@Injectable()
export class ServidorsService extends BngRestapiService<Servidor> {

    constructor( injector: Injector ) {
        super( Servidor, 'servidor', injector, 'rrhh' );
    }

}