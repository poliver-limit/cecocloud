import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class PerfilUsuariEmpresa extends Resource { }

@Injectable()
export class PerfilUsuariEmpresaService extends BngRestapiService<PerfilUsuariEmpresa> {

    constructor(injector: Injector) {
        super(PerfilUsuariEmpresa, 'perfilUsuariEmpresa', injector);
    }

}