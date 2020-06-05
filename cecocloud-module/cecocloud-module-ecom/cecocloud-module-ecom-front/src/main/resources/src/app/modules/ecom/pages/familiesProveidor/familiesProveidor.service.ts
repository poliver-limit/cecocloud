import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class FamiliaProveidor extends RestapiResource {}

@Injectable()
export class FamiliesProveidorService extends BngRestapiService<FamiliaProveidor> {

    constructor( injector: Injector ) {
        super( FamiliaProveidor, 'familiaProveidor', injector, 'ecom' );
    }

}