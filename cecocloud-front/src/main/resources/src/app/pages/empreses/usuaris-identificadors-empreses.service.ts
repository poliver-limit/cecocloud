import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class UsuariIdentificadorEmpresa extends Resource {}

@Injectable()
export class UsuarisIdentificadorsEmpresesService extends BngRestapiService<UsuariIdentificadorEmpresa> {

    constructor( injector: Injector ) {
        super( UsuariIdentificadorEmpresa, 'usuariIdentificadorEmpresa', injector );
    }

}