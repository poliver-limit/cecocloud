import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class EmpresaRrhh extends Resource {}

@Injectable()
export class EmpresesRrhhService extends BngRestapiService<EmpresaRrhh> {

    constructor( injector: Injector ) {
        super( EmpresaRrhh, 'empresaRrhh', injector, 'rrhh' );
    }

}