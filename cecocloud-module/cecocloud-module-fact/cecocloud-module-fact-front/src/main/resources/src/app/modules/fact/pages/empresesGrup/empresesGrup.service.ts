import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class EmpresaGrup extends RestapiResource {}

@Injectable()
export class EmpresesGrupService extends BngRestapiService<EmpresaGrup> {

    constructor( injector: Injector ) {
        super( EmpresaGrup, 'empresaGrup', injector, 'fact' );
    }

}