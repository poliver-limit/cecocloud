import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class EmpresaEcom extends RestapiResource {}

@Injectable()
export class EmpresesEcomService extends BngRestapiService<EmpresaEcom> {

    constructor( injector: Injector ) {
        super( EmpresaEcom, 'empresa', injector, 'ecom' );
    }

}