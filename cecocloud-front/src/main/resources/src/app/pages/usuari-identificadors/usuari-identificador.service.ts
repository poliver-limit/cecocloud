import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class UsuariIdentificador extends Resource {}

@Injectable()
export class UsuariIdentificadorService extends BngRestapiService<UsuariIdentificador> {

    constructor( injector: Injector ) {
        super( UsuariIdentificador, 'usuariIdentificador', injector );
    }

}