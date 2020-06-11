import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class CaixaMoviment extends RestapiResource {}

@Injectable()
export class CaixesMovimentService extends BngRestapiService<CaixaMoviment> {

    constructor( injector: Injector ) {
        super( CaixaMoviment, 'caixaMoviment', injector, 'ecom' );
    }

}