import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class LiniaFullFeina extends RestapiResource {}

@Injectable()
export class LiniesFullFeinaService extends BngRestapiService<LiniaFullFeina> {

    constructor( injector: Injector ) {
        super( LiniaFullFeina, 'liniaFullFeina', injector, 'fact' );
    }

}