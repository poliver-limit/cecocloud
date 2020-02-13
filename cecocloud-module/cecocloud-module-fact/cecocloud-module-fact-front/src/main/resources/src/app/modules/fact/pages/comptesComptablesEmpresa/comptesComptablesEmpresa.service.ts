import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class CompteComptableEmpresa extends RestapiResource {}

@Injectable()
export class ComptesComptablesEmpresaService extends BngRestapiService<CompteComptableEmpresa> {

    constructor( injector: Injector ) {
        super( CompteComptableEmpresa, 'compteComptableEmpresa', injector, 'fact' );
    }

}