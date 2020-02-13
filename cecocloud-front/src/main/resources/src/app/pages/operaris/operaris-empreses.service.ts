import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class OperariEmpresa extends RestapiResource {}

@Injectable()
export class OperarisEmpresesService extends BngRestapiService<OperariEmpresa> {

    constructor( injector: Injector ) {
        super( OperariEmpresa, 'operariEmpresa', injector );
    }

}