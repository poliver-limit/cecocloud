import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class ProjecteAplicacio extends RestapiResource {}

@Injectable()
export class ProjectesAplicacioService extends BngRestapiService<ProjecteAplicacio> {

    constructor( injector: Injector ) {
        super( ProjecteAplicacio, 'projecteAplicacio', injector, 'fact' );
    }

}