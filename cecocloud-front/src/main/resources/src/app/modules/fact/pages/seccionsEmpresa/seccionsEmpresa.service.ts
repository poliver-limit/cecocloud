import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class SeccioEmpresa extends Resource {}

@Injectable()
export class SeccionsEmpresaService extends BngRestapiService<SeccioEmpresa> {

    constructor( injector: Injector ) {
        super( SeccioEmpresa, 'seccioEmpresa', injector, 'fact' );
    }

}