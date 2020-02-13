import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class CompteCorrentEmpresa extends RestapiResource {}

@Injectable()
export class ComptesCorrentsEmpresaService extends BngRestapiService<CompteCorrentEmpresa> {

    constructor( injector: Injector ) {
        super( CompteCorrentEmpresa, 'compteCorrentEmpresa', injector, 'fact' );
    }

}