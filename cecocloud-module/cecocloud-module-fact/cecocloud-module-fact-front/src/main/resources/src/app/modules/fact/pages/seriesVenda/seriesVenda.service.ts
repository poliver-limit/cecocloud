import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class SerieVenda extends RestapiResource {}

@Injectable()
export class SeriesVendaService extends BngRestapiService<SerieVenda> {

    constructor( injector: Injector ) {
        super( SerieVenda, 'serieVenda', injector, 'fact' );
    }

}