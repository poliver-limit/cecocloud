import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Pais extends RestapiResource {}

@Injectable()
export class PaisosService extends BngRestapiService<Pais> {

    constructor( injector: Injector ) {
        super( Pais, 'pais', injector, 'ecom' );
    }

}