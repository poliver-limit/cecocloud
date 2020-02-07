import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class FuncionalitatRecurs extends Resource {}

@Injectable()
export class FuncionalitatsRecursosService extends BngRestapiService<FuncionalitatRecurs> {

    constructor( injector: Injector ) {
        super( FuncionalitatRecurs, 'funcionalitatRecurs', injector );
    }

}