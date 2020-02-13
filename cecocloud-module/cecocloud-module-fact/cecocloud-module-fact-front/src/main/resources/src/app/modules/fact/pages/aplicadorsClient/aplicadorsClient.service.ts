import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class AplicadorClient extends RestapiResource {}

@Injectable()
export class AplicadorsClientService extends BngRestapiService<AplicadorClient> {

    constructor( injector: Injector ) {
        super( AplicadorClient, 'aplicadorClient', injector, 'fact' );
    }

}