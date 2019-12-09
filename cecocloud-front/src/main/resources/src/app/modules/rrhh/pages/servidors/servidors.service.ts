import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Servidor extends Resource {}

@Injectable()
export class ServidorsService extends BngRestapiService<Servidor> {

    constructor( injector: Injector ) {
        super( Servidor, 'servidor', injector, 'rrhh' );
    }

}