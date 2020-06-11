import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class FacturaBase extends RestapiResource {}

@Injectable()
export class FacturesBaseService extends BngRestapiService<FacturaBase> {

    constructor( injector: Injector ) {
        super( FacturaBase, 'facturaBase', injector, 'ecom' );
    }

}