import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class FuncionalitatIdentificador extends RestapiResource {}

@Injectable()
export class FuncionalitatsIdentificadorsService extends BngRestapiService<FuncionalitatIdentificador> {

    constructor( injector: Injector ) {
        super( FuncionalitatIdentificador, 'funcionalitatIdentificador', injector );
    }

}