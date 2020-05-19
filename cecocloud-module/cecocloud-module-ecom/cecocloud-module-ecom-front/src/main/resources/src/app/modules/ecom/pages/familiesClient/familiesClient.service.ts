import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class FamiliaClient extends RestapiResource {}

@Injectable()
export class FamiliesClientService extends BngRestapiService<FamiliaClient> {

    constructor( injector: Injector ) {
        super( FamiliaClient, 'familiaClient', injector, 'ecom' );
    }

}