import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class ProjectePressupost extends RestapiResource {}

@Injectable()
export class ProjectesPressupostService extends BngRestapiService<ProjectePressupost> {

    constructor( injector: Injector ) {
        super( ProjectePressupost, 'projectePressupost', injector, 'fact' );
    }

}