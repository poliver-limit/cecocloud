import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class EmpresaFact extends Resource {}

@Injectable()
export class EmpresesFactService extends BngRestapiService<EmpresaFact> {

    constructor( injector: Injector ) {
        super( EmpresaFact, 'empresaFact', injector, 'fact' );
    }

}