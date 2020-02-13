import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class RegistreDiari extends RestapiResource {}

@Injectable()
export class RegistresDiariService extends BngRestapiService<RegistreDiari> {

    constructor( injector: Injector ) {
        super( RegistreDiari, 'registreDiari', injector, 'rrhh' );
    }

}