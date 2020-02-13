import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class TarifaDescompte extends RestapiResource {}

@Injectable()
export class TarifesDescompteService extends BngRestapiService<TarifaDescompte> {

    constructor( injector: Injector ) {
        super( TarifaDescompte, 'tarifaDescompte', injector, 'fact' );
    }

}