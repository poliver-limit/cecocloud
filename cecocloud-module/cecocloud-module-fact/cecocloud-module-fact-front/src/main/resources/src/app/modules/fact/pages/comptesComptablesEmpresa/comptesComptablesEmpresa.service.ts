import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class CompteComptableEmpresa extends Resource {}

@Injectable()
export class ComptesComptablesEmpresaService extends BngRestapiService<CompteComptableEmpresa> {

    constructor( injector: Injector ) {
        super( CompteComptableEmpresa, 'compteComptableEmpresa', injector, 'fact' );
    }

}