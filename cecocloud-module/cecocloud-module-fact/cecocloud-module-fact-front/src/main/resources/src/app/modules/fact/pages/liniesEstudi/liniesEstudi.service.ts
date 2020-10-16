import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class LiniaEstudi extends RestapiResource {}

@Injectable()
export class LiniesEstudiService extends BngRestapiService<LiniaEstudi> {

    constructor( injector: Injector ) {
        super( LiniaEstudi, 'liniaEstudi', injector, 'fact' );
    }

}