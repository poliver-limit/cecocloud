import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class VencimentPagat extends RestapiResource {}

@Injectable()
export class VencimentsPagatService extends BngRestapiService<VencimentPagat> {

    constructor( injector: Injector ) {
        super( VencimentPagat, 'vencimentPagat', injector, 'ecom' );
    }

}