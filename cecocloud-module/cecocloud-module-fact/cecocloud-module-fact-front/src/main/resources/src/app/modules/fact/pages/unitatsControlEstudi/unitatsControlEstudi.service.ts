import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class UnitatControlEstudi extends RestapiResource {}

@Injectable()
export class UnitatsControlEstudiService extends BngRestapiService<UnitatControlEstudi> {

    constructor( injector: Injector ) {
        super( UnitatControlEstudi, 'unitatControlEstudi', injector, 'fact' );
    }

}