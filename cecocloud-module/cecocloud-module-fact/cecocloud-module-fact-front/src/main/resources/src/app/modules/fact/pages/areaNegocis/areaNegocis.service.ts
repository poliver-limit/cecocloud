import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class AreaNegoci extends RestapiResource {}

@Injectable()
export class AreaNegocisService extends BngRestapiService<AreaNegoci> {

    constructor( injector: Injector ) {
        super( AreaNegoci, 'areaNegoci', injector, 'fact' );
    }

}