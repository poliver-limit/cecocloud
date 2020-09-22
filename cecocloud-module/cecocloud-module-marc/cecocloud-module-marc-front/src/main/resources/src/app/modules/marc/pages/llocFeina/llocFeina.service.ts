import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class LlocFeina extends RestapiResource {}

@Injectable()
export class LlocFeinaService extends BngRestapiService<LlocFeina> {

    constructor( injector: Injector ) {
        super( LlocFeina, 'llocFeina', injector, 'marc' );
    }

}