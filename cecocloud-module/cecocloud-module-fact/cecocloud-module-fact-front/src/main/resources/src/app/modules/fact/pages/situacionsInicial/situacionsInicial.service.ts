import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class SituacioInicial extends RestapiResource {}

@Injectable()
export class SituacionsInicialService extends BngRestapiService<SituacioInicial> {

    constructor( injector: Injector ) {
        super( SituacioInicial, 'situacioInicial', injector, 'fact' );
    }

}