import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class AltresAplicacions extends RestapiResource {}

@Injectable()
export class AltresAplicacionsService extends BngRestapiService<AltresAplicacions> {

    constructor( injector: Injector ) {
        super( AltresAplicacions, 'altresAplicacions', injector, 'fact' );
    }

}