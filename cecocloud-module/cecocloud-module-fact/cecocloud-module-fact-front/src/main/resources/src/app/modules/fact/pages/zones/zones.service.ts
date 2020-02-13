import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Zona extends RestapiResource {}

@Injectable()
export class ZonesService extends BngRestapiService<Zona> {

    constructor( injector: Injector ) {
        super( Zona, 'zona', injector, 'fact' );
    }

}