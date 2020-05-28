import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Caixa extends RestapiResource {}

@Injectable()
export class CaixesService extends BngRestapiService<Caixa> {

    constructor( injector: Injector ) {
        super( Caixa, 'caixa', injector, 'ecom' );
    }

}