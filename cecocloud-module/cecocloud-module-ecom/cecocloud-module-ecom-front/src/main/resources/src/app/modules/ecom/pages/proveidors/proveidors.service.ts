import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Proveidor extends RestapiResource {}

@Injectable()
export class ProveidorsService extends BngRestapiService<Proveidor> {

    constructor( injector: Injector ) {
        super( Proveidor, 'proveidor', injector, 'ecom' );
    }

}