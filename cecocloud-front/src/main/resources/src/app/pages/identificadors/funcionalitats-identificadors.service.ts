import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class FuncionalitatIdentificador extends Resource {}

@Injectable()
export class FuncionalitatsIdentificadorsService extends BngRestapiService<FuncionalitatIdentificador> {

    constructor( injector: Injector ) {
        super( FuncionalitatIdentificador, 'funcionalitatIdentificador', injector );
    }

}