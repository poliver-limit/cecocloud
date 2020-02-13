import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class EmpresaFact extends RestapiResource {}

@Injectable()
export class EmpresesFactService extends BngRestapiService<EmpresaFact> {

    constructor( injector: Injector ) {
        super( EmpresaFact, 'empresa', injector, 'fact' );
    }

}