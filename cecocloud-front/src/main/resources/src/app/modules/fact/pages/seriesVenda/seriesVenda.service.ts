import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class SerieVenda extends Resource {}

@Injectable()
export class SeriesVendaService extends BngRestapiService<SerieVenda> {

    constructor( injector: Injector ) {
        super( SerieVenda, 'serieVenda', injector, 'fact' );
    }

}