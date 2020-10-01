import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class PreuPerGamma extends RestapiResource {}

@Injectable()
export class PreusPerGammaService extends BngRestapiService<PreuPerGamma> {

    constructor( injector: Injector ) {
        super( PreuPerGamma, 'preuPerGamma', injector, 'fact' );
    }

}