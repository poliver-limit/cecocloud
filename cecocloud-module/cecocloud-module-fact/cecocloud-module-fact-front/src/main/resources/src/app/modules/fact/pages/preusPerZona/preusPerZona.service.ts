import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class PreuPerZona extends RestapiResource {}

@Injectable()
export class PreusPerZonaService extends BngRestapiService<PreuPerZona> {

    constructor( injector: Injector ) {
        super( PreuPerZona, 'preuPerZona', injector, 'fact' );
    }

}