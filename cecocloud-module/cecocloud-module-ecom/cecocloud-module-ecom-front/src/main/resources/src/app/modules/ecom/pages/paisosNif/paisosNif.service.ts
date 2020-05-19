import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class PaisNif extends RestapiResource {}

@Injectable()
export class PaisosNifService extends BngRestapiService<PaisNif> {

    constructor( injector: Injector ) {
        super( PaisNif, 'paisNif', injector, 'ecom' );
    }

}