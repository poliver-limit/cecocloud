import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class FamiliaCost extends RestapiResource {}

@Injectable()
export class FamiliesCostService extends BngRestapiService<FamiliaCost> {

    constructor( injector: Injector ) {
        super( FamiliaCost, 'familiaCost', injector, 'fact' );
    }

}