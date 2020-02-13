import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class ZonaRrhh extends RestapiResource {}

@Injectable()
export class ZonesRrhhService extends BngRestapiService<ZonaRrhh> {

    constructor( injector: Injector ) {
        super( ZonaRrhh, 'zona', injector, 'rrhh' );
    }

}