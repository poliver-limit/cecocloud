import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class SerieCompra extends Resource {}

@Injectable()
export class SeriesCompraService extends BngRestapiService<SerieCompra> {

    constructor( injector: Injector ) {
        super( SerieCompra, 'serieCompra', injector, 'fact' );
    }

}