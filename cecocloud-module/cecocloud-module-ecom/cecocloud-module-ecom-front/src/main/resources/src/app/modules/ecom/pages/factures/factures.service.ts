import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Factura extends RestapiResource {}

@Injectable()
export class FacturesService extends BngRestapiService<Factura> {

    constructor( injector: Injector ) {
        super( Factura, 'factura', injector, 'ecom' );
    }

}