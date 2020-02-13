import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class SeccioEmpresa extends RestapiResource {}

@Injectable()
export class SeccionsEmpresaService extends BngRestapiService<SeccioEmpresa> {

    constructor( injector: Injector ) {
        super( SeccioEmpresa, 'seccioEmpresa', injector, 'fact' );
    }

}