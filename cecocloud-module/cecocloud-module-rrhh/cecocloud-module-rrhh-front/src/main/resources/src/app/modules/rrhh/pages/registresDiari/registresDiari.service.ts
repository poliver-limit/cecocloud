import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class RegistreDiari extends Resource {}

@Injectable()
export class RegistresDiariService extends BngRestapiService<RegistreDiari> {

    constructor( injector: Injector ) {
        super( RegistreDiari, 'registreDiari', injector, 'rrhh' );
    }

}