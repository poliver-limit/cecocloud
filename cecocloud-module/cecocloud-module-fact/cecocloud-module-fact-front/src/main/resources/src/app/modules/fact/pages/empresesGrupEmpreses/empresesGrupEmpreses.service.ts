import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class EmpresaGrupEmpreses extends RestapiResource {}

@Injectable()
export class EmpresesGrupEmpresesService extends BngRestapiService<EmpresaGrupEmpreses> {

    constructor( injector: Injector ) {
        super( EmpresaGrupEmpreses, 'empresaGrupEmpreses', injector, 'fact' );
    }

}