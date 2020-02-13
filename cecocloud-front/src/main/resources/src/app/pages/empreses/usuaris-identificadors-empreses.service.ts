import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class UsuariIdentificadorEmpresa extends RestapiResource {}

@Injectable()
export class UsuarisIdentificadorsEmpresesService extends BngRestapiService<UsuariIdentificadorEmpresa> {

    constructor( injector: Injector ) {
        super( UsuariIdentificadorEmpresa, 'usuariIdentificadorEmpresa', injector );
    }

}