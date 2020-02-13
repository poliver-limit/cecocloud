import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class SituacioComercial extends RestapiResource {}

@Injectable()
export class SituacionsComercialService extends BngRestapiService<SituacioComercial> {

    constructor( injector: Injector ) {
        super( SituacioComercial, 'situacioComercial', injector, 'fact' );
    }

}