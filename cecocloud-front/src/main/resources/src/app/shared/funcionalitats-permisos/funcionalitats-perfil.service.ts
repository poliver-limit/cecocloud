import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class FuncionalitatIdentificadorPerfil extends Resource { }

@Injectable()
export class FuncionalitatsIdentificadorPerfilService extends BngRestapiService<FuncionalitatIdentificadorPerfil> {

    constructor(injector: Injector) {
        super(FuncionalitatIdentificadorPerfil, 'funcionalitatIdentificadorPerfil', injector);
    }

}