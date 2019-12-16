import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class PerfilUsuariIdentificadorEmpresa extends Resource { }

@Injectable()
export class PerfilUsuariIdentificadorEmpresaService extends BngRestapiService<PerfilUsuariIdentificadorEmpresa> {

    constructor(injector: Injector) {
        super(PerfilUsuariIdentificadorEmpresa, 'perfilUsuariIdentificadorEmpresa', injector);
    }

}