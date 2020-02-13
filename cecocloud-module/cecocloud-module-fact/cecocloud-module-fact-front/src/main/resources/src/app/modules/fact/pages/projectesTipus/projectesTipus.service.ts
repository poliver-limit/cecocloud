import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class ProjecteTipus extends RestapiResource {}

@Injectable()
export class ProjectesTipusService extends BngRestapiService<ProjecteTipus> {

    constructor( injector: Injector ) {
        super( ProjecteTipus, 'projecteTipus', injector, 'fact' );
    }

}