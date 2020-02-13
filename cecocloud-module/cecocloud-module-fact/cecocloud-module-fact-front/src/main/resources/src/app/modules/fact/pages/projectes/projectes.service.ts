import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Projectes extends RestapiResource {}

@Injectable()
export class ProjectesService extends BngRestapiService<Projectes> {

    constructor( injector: Injector ) {
        super( Projectes, 'projecte', injector, 'fact' );
    }

}