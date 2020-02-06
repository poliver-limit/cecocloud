import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class CompteCorrentEmpresa extends Resource {}

@Injectable()
export class ComptesCorrentsEmpresaService extends BngRestapiService<CompteCorrentEmpresa> {

    constructor( injector: Injector ) {
        super( CompteCorrentEmpresa, 'compteCorrentEmpresa', injector, 'fact' );
    }

}