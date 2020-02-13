import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class FuncionalitatRecurs extends RestapiResource {}

@Injectable()
export class FuncionalitatsRecursosService extends BngRestapiService<FuncionalitatRecurs> {

    constructor( injector: Injector ) {
        super( FuncionalitatRecurs, 'funcionalitatRecurs', injector );
    }

}