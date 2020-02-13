import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class UsuariIdentificador extends RestapiResource {}

@Injectable()
export class UsuariIdentificadorService extends BngRestapiService<UsuariIdentificador> {

    constructor( injector: Injector ) {
        super( UsuariIdentificador, 'usuariIdentificador', injector );
    }

}