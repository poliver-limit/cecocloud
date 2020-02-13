import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class FuncionalitatIdentificadorPerfil extends RestapiResource { }

@Injectable()
export class FuncionalitatsIdentificadorPerfilService extends BngRestapiService<FuncionalitatIdentificadorPerfil> {

    constructor(injector: Injector) {
        super(FuncionalitatIdentificadorPerfil, 'funcionalitatIdentificadorPerfil', injector);
    }

}