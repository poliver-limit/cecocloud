import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class CodiPostal extends RestapiResource {}

@Injectable()
export class CodisPostalService extends BngRestapiService<CodiPostal> {

    constructor( injector: Injector ) {
        super( CodiPostal, 'codiPostal', injector, 'fact' );
    }

}