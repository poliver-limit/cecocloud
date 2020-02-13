import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class TipusDia extends RestapiResource {}

@Injectable()
export class TipusDiesService extends BngRestapiService<TipusDia> {

    constructor( injector: Injector ) {
        super( TipusDia, 'tipusDia', injector, 'rrhh' );
    }

}