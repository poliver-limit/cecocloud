import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class OperariEmpresa extends Resource {}

@Injectable()
export class OperarisEmpresesService extends BngRestapiService<OperariEmpresa> {

    constructor( injector: Injector ) {
        super( OperariEmpresa, 'operariEmpresa', injector );
    }

}