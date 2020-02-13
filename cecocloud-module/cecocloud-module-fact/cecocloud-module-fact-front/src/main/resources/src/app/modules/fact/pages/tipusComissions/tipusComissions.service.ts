import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class TipusComissio extends RestapiResource {}

@Injectable()
export class TipusComissionsService extends BngRestapiService<TipusComissio> {

    constructor( injector: Injector ) {
        super( TipusComissio, 'tipusComissio', injector, 'fact' );
    }

}