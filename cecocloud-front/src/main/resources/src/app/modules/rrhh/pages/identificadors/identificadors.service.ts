import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Identificador extends Resource {}

@Injectable()
export class IdentificadorsService extends BngRestapiService<Identificador> {

    constructor( injector: Injector ) {
        super( Identificador, 'identificador', injector, 'rrhh' );
    }

}