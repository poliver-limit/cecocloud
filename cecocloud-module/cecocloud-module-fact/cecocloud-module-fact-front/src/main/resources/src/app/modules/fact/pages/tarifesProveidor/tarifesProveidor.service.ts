import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class TarifaProveidor extends RestapiResource {}

@Injectable()
export class TarifesProveidorService extends BngRestapiService<TarifaProveidor> {

    constructor( injector: Injector ) {
        super( TarifaProveidor, 'tarifaProveidor', injector, 'fact' );
    }

}