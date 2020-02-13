import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class SerieCompra extends RestapiResource {}

@Injectable()
export class SeriesCompraService extends BngRestapiService<SerieCompra> {

    constructor( injector: Injector ) {
        super( SerieCompra, 'serieCompra', injector, 'fact' );
    }

}