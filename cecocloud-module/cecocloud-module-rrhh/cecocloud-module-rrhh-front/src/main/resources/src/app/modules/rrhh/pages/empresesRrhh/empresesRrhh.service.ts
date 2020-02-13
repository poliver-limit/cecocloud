import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class EmpresaRrhh extends RestapiResource {}

@Injectable()
export class EmpresesRrhhService extends BngRestapiService<EmpresaRrhh> {

    constructor( injector: Injector ) {
        super( EmpresaRrhh, 'empresa', injector, 'rrhh' );
    }

}